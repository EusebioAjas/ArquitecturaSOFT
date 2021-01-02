package cliente;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
  private static final String IP_ADDRESS = "127.0.0.1";
  private static final int PORT = 59090;

  public static void main(String[] args) throws IOException {
    var socket = new Socket(IP_ADDRESS, PORT);
    var in = new Scanner(socket.getInputStream());
    System.out.println("Server response: " + in.nextLine());
  }
}