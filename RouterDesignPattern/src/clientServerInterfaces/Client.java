package clientServerInterfaces;

import requestInterfaces.Response;

@FunctionalInterface
public interface Client {
  <T extends Response<?>> void onServerResponse(T reponse);
}
