package sample;

import clientServerInterfaces.Client;
import requestInterfaces.Response;

public class ClientImpl implements Client {
  @Override
  public <T extends Response<?>> void onServerResponse(T reponse) {
    System.out.println(reponse.getResponse());
  }
}
