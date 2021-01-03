package broker;

import broker.entidades.*;
import broker.exceptions.ServerErrorException;
import broker.exceptions.ServiceAlreadyDefinedException;
import broker.exceptions.ServiceNotAvailableException;
import broker.exceptions.ServiceNotFoundException;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BrokerThread implements Runnable {
  private Broker broker;
  private Socket sockerBroker;
  private Socket proxyServer;
  private static int totalThreads = 0;

  private PrintWriter outClient;
  private BufferedReader inputClient;
  private PrintWriter outServer;
  private BufferedReader inputServer;

  public BrokerThread(Broker broker, Socket sockerBroker) {
    this.broker = broker;
    this.sockerBroker = sockerBroker;

    System.out.println("Thread #" + (++totalThreads) + " on Broker");
  }


  @Override
  public void run() {
    try {
      initClientBuffers();
      connect();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void connect() throws IOException {
    final int currentThread = totalThreads;

    String inputLine = null;
    String processedInputLine = null;
    Protocol protocol = new Protocol();
    processedInputLine = protocol.processInput(inputLine);
    outClient.println(processedInputLine);

    while ((inputLine = inputClient.readLine()) != null) {
      processedInputLine = protocol.processInput(inputLine);
      System.out.println("Current thread #" + currentThread + " request: " + processedInputLine);

      Request request = new Gson().fromJson(processedInputLine, Request.class);

      if (request.getType() == TypeRequest.FIND) {
        try {
          Service serviceRequested;
          serviceRequested = broker.findService(request.getServiceName());
          if (!isNull(serviceRequested)) {
            responseToCliente(TypeResponse.SERVICE_FOUND);
          }
        } catch (ServiceNotFoundException e) {
          responseToCliente(TypeResponse.SERVICE_NOT_FOUND);
          break;
        }
      }

      if (request.getType() == TypeRequest.EXECUTE) {
        executeServiceProccess(request);
        break;
      }

      if (request.getType() == TypeRequest.REGISTER) {
        registerServiceProccess(request);
        break;
      }

      if (request.getType() == TypeRequest.CHANGE_STATUS) {
        changeServiceSatusProccess(request);
        break;
      }

      if (processedInputLine.equals("Close.")) {
        break;
      }
    }
    sockerBroker.close();
    System.out.println("Discconect current thread # " + currentThread);
  }

  private void changeServiceSatusProccess(Request request) {
    try {
      broker.changeServiceState(
              request.getServiceName(),
              Boolean.parseBoolean(request.getData())
      );
    } catch (ServiceNotFoundException e) {
      responseToCliente(TypeResponse.SERVICE_NOT_FOUND);
    }
  }

  private void registerServiceProccess(Request request) {
    SocketAddr socketAddr = new SocketAddr(
            sockerBroker.getLocalAddress().getHostName(),
            Integer.parseInt(request.getData()));

    Service service = new Service(socketAddr, request.getServiceName());

    try {
      broker.registerService(service);
    } catch (ServiceAlreadyDefinedException e) {
      responseToCliente(TypeResponse.SERVICE_ALREADY_DEFINED);
    }
  }

  private void executeServiceProccess(Request request) {
    Service service = null;
    try {
      service = broker.findService(request.getServiceName());
      if (!service.isActive()) {
        throw new ServiceNotAvailableException();
      }
    } catch (ServiceNotFoundException e) {
      responseToCliente(TypeResponse.SERVICE_NOT_FOUND);
    } catch (ServiceNotAvailableException e) {
      responseToCliente(TypeResponse.SERVICE_NOT_AVAILABLE);
    }
    String data = request.getData();
    startService(service, data);
  }

  //Detalles con el null, no se validaba
  private void startService(Service service, String data) {
    if (!isNull(service)) {
      String hostName = service.getSocketAddr().getIP();
      int port = service.getSocketAddr().getPort();

      try {
        connectToProxyServer(hostName, port);
        initServerBuffers();
        sendRequest(service.getService(), data);
      } catch (IOException | ServerErrorException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private void responseToCliente(int type) {
    Response brokerResponse = new Response();
    brokerResponse.setType(type);
    outClient.println(new Gson().toJson(brokerResponse));
  }

  private void sendRequest(String serviceName, String data) throws IOException, ServerErrorException {
    String proxyServerResponse;
    Request brokerRequest;

    while ((proxyServerResponse = inputServer.readLine()) != null) {
      System.out.println("Proxy response: " + proxyServerResponse);

      Response brokerResponse = new Gson().fromJson(proxyServerResponse, Response.class);
      int responseType = brokerResponse.getType();

      if (responseType == TypeResponse.CONNECTED) {
        brokerRequest = new Request();
        brokerRequest.setType(TypeRequest.EXECUTE);
        brokerRequest.setServiceName(serviceName);
        brokerRequest.setData(data);
        System.out.println(new Gson().toJson(brokerRequest));
      }

      if (responseType == TypeResponse.REQUEST_RECEIVED) {
        System.out.println(brokerResponse.getMessage());
        break;
      }

      if (responseType == TypeResponse.REQUEST_ERROR) {
        throw new ServerErrorException();
      }
    }
    proxyServer.close();
  }

  public void connectToProxyServer(String hostName, int portNumber) throws IOException {
    proxyServer = new Socket(hostName, portNumber);
  }

  private boolean isNull(Object o) {
    return o == null;
  }

  public void initClientBuffers() throws IOException {
    outClient = new PrintWriter(sockerBroker.getOutputStream(), true);
    inputClient = new BufferedReader(
            new InputStreamReader(sockerBroker.getInputStream())
    );
  }

  public void initServerBuffers() throws IOException {
    outServer = new PrintWriter(proxyServer.getOutputStream(), true);
    inputServer = new BufferedReader(
            new InputStreamReader(proxyServer.getInputStream())
    );
  }
}
