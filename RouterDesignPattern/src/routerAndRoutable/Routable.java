package routerAndRoutable;

import clientServerInterfaces.Client;
import clientServerInterfaces.Server;
import requestInterfaces.Request;

public interface Routable {
  <T extends Client> void registerClient(T clientimpl);

  void registerServer(Class<? extends Server> serverImpl);

  <T extends Request<?>> void routerClientToServer(Class<? extends Client> clientImpl, Class<? extends Server> serverImpl, T request);

  void removeClient(Class<?> clientClass);

  void removeAllClients();

  void removeServer(Class<?> serverClass);

  void removeAllServers();

  boolean isRegistered(Class<?> otherClass);
}
