package routerAndRoutable;

import clientServerInterfaces.Client;
import clientServerInterfaces.Server;
import requestInterfaces.Request;

import java.util.*;

public class Router implements Routable {
  private Map<String, Client> clients = new HashMap<>();

  public Set<Class<? extends Client>> clientSet = new HashSet<>();
  public Set<Class<? extends Server>> serverSet = new HashSet<>();
  private static final Router ROUTER = new Router();

  private Router() {

  }

  public static Router turnOn() {
    return ROUTER;
  }

  @Override
  public <T extends Client> void registerClient(T clientimpl) {
    doNotAllowNullValue(clientimpl);
    clientSet.add(clientimpl.getClass());
    clients.put(clientimpl.getClass().getName(), clientimpl);
  }

  @Override
  public void registerServer(Class<? extends Server> serverImpl) {
    doNotAllowNullValue(serverImpl);
    serverSet.add(serverImpl);
  }

  @Override
  public <T extends Request<?>> void routerClientToServer(Class<? extends Client> clientImpl, Class<? extends Server> serverImpl, T request) {
    doNotAllowNullValue(clientImpl);
    doNotAllowNullValue(serverImpl);
    doNotAllowNullValue(request);
    doNotAllowUnregisteredNullValue(isRegistered(clientImpl));
    doNotAllowUnregisteredNullValue(isRegistered(serverImpl));

    try {
      serverImpl.newInstance().onClientRequest(request, clients.get(clientImpl.getName()));
    } catch (IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void removeClient(Class<?> clientClass) {
    clients.remove(clientClass.getName());
    clientSet.remove(clientClass);
  }

  @Override
  public void removeAllClients() {
    clientSet.clear();
  }

  @Override
  public void removeServer(Class<?> serverClass) {
    serverSet.remove(serverClass);
  }

  @Override
  public void removeAllServers() {
    serverSet.clear();
  }

  @Override
  public boolean isRegistered(Class<?> otherClass) {
    boolean result = false;
    boolean searchBreak = false;
    Iterator<Class<? extends Client>> iterator = clientSet.iterator();
    while (iterator.hasNext()) {
      Class<? extends Client> next = iterator.next();
      if (next.getName().equals(otherClass.getName())) {
        result = true;
        searchBreak = true;
        break;
      }
    }
    if (!searchBreak) {
      Iterator<Class<? extends Server>> it = serverSet.iterator();
      while (it.hasNext()) {
        Class<? extends Server> next = it.next();
        if (next.getName().equals(otherClass.getName())) {
          result = true;
          searchBreak = true;
          break;
        }
      }
    }
    return result;
  }

  private void doNotAllowNullValue(Object tocheck) {
    if (tocheck == null) {
      final String msg = "You can't pass null to this method";
      throw new NullPointerException(msg);
    }
  }

  private void doNotAllowUnregisteredNullValue(boolean isRegistered) {
    if (!isRegistered) {
      final String msg = "Either the client or the server was not registered in this router. Resgister it first!";
      throw new IllegalArgumentException(msg);
    }
  }
}
