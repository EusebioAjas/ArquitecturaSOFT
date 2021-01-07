package com.API.src;

import com.API.src.entidades.Response;
import com.API.src.entidades.TypeRequest;
import com.API.src.entidades.TypeResponse;
import com.API.src.exceptions.ServiceAlreadyDefinedException;
import com.API.src.exceptions.ServiceNotAvailableException;
import com.API.src.exceptions.ServiceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {
  private String ip;
  private int port;

  private Socket socket;
  private PrintWriter socketOutput;
  private BufferedReader socketInput;

  public Connection(String ip, int port) {
    this.ip = ip;
    this.port = port;
  }

  public void open() {
    connectToBroker();
    initBuffers();
  }

  public void connectToBroker() {
    try {
      socket = new Socket(ip, port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void initBuffers() {
    try {
      socketOutput = new PrintWriter(socket.getOutputStream(), true);
      socketInput = new BufferedReader(
              new InputStreamReader(socket.getInputStream())
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void resgisterService(int port, String serviceName)
          throws ServiceAlreadyDefinedException, IOException {
    String forwardRequest = packData(
            TypeRequest.REGISTER,
            serviceName,
            String.valueOf(port)
    );
    socketOutput.println(forwardRequest);

    String brokerResponse;
    while ((brokerResponse = socketInput.readLine()) != null) {
      Response reponse = unpackData(brokerResponse);
      if (reponse.getType() == TypeResponse.SERVICE_ALREADY_DEFINED) {
        throw new ServiceAlreadyDefinedException();
      }
    }
  }

  public void changeServiceState(String serviceName, boolean status) throws ServiceAlreadyDefinedException, IOException {
    String forwardRequest = packData(
            TypeRequest.CHANGE_STATUS,
            serviceName,
            String.valueOf(status)
    );
    socketOutput.println(forwardRequest);

    String response;
    while ((response = socketInput.readLine()) != null) {
      Response brokerResponse = unpackData(response);

      if (brokerResponse.getType() == TypeResponse.SERVICE_NOT_FOUND) {
        throw new ServiceAlreadyDefinedException();
      }
    }
  }

  public boolean findService(String serviceName) throws IOException {
    String forwardRequest = packData(
            TypeRequest.FIND,
            serviceName,
            null
    );
    socketOutput.println(forwardRequest);

    String brokerResponse;
    boolean isFoundService = false;
    while ((brokerResponse = socketInput.readLine()) != null) {
      Response response = unpackData(brokerResponse);

      if (response.getType() == TypeResponse.SERVICE_FOUND) {
        isFoundService = true;
        System.out.println("Se encontro");
        break;
      }
    }
    return isFoundService;
  }

  public void executeService(String serviceName, String jsonData)
          throws IOException, ServiceNotAvailableException, ServiceNotFoundException {
    String forwardRequest = packData(
            TypeRequest.EXECUTE,
            serviceName,
            jsonData
    );
    socketOutput.println(forwardRequest);

    String brokerResponse;
    while ((brokerResponse = socketInput.readLine()) != null) {
      Response response = unpackData(brokerResponse);
      if (response.getType() == TypeResponse.SERVICE_NOT_AVAILABLE) {
        throw new ServiceNotAvailableException();
      }

      if (response.getType() == TypeResponse.SERVICE_NOT_FOUND) {
        throw new ServiceNotFoundException();
      }
    }
  }

  public Response unpackData(String response) {
    Response brokerResponse;
    brokerResponse = new Gson().fromJson(response, Response.class);
    return brokerResponse;
  }

  private String packData(int type, String serviceName, String data) {
    String entity;
    JsonObject json = new JsonObject();
    json.addProperty("type", type);
    json.addProperty("serviceName", serviceName);
    json.addProperty("data", data);
    entity = json.toString();
    return entity;
  }

  public void close() {
    try {
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return ip + ", " + port;
  }
}
