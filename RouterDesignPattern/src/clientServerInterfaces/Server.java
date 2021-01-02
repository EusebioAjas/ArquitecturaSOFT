package clientServerInterfaces;

import requestInterfaces.Request;

@FunctionalInterface
public interface Server {
  <T extends Request<?>> void onClientRequest(T request, Client client);
}
