package cliente;


import uicliente.View;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
  private static final String IP_ADDRESS = "127.0.0.1";
  private static final int PORT = 59090;

  public static void main(String[] args) throws IOException {
    System.out.println("Connected server...");
    View view = new View();
    try (var socket = new Socket(IP_ADDRESS, PORT)) {
      var in = view.getInfo();
      var out = new PrintWriter(socket.getOutputStream(), true);
      out.println(in);
      System.out.println("response: " + in);
    }
  }
}