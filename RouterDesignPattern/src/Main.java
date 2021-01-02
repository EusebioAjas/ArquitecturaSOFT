import routerAndRoutable.Router;
import sample.ClientImpl;
import sample.ServerImpl;
import sample.ServerRequest;
//Test
public class Main {
  public static void main(String[] args) {
    Router.turnOn().registerClient(new ClientImpl());
    Router.turnOn().registerServer(ServerImpl.class);
    String strequest = "Client is sending a request to server...";
    ServerRequest request = new ServerRequest();
    request.setRequest(strequest);
    Router.turnOn().routerClientToServer(ClientImpl.class, ServerImpl.class, request);
  }
}
