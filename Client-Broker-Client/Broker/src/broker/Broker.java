package broker;

import broker.entidades.Service;
import broker.exceptions.ServiceAlreadyDefinedException;
import broker.exceptions.ServiceNotFoundException;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class Broker {
  private static final int PORT_NUMBER = 59001;
  private HashMap<String, Service> services;
  private ServerSocket serverSocket;

  public Broker() {
    services = new HashMap<>();
  }

  public void registerService(Service service) throws ServiceAlreadyDefinedException {
    registerService(service.getService(), service);
  }

  public void registerService(String name, Service service) throws ServiceAlreadyDefinedException {
    if (!services.containsKey(name)) {
      services.put(name, service);
    } else {
      throw new ServiceAlreadyDefinedException();
    }
  }

  public void changeServiceState(String serviceName, boolean status) throws ServiceNotFoundException {
    findService(serviceName).setActive(status);
  }

  public Service findService(String serviceName) throws ServiceNotFoundException {
    if (services.containsKey(serviceName)) {
      return services.get(serviceName);
    } else {
      throw new ServiceNotFoundException();
    }
  }

  public void acceptConnection() {
    boolean listening = true;
    try {
      serverSocket = new ServerSocket(PORT_NUMBER);
      System.out.println("Listening on port: " + PORT_NUMBER);
      while (listening) {
        new Thread(new BrokerThread(this, serverSocket.accept())).start();
      }
    } catch (IOException e) {
      System.out.println("Could not listen on port " + PORT_NUMBER);
      System.exit(-1);
    }
  }

  public static void main(String[] args) {
    Broker broker = new Broker();
    broker.acceptConnection();
  }

}
