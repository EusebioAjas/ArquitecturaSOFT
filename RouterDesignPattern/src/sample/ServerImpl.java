package sample;

import clientServerInterfaces.Client;
import clientServerInterfaces.Server;
import requestInterfaces.Request;

public class ServerImpl implements Server {
  @Override
  public <T extends Request<?>> void onClientRequest(T request, Client client) {
    ClientResponse clientResponse = new ClientResponse();
    clientResponse.setResponse("Server is sending a response to client...");
    client.onServerResponse(clientResponse);
  }
}
