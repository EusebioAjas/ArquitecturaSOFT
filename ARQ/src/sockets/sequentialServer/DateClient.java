package sockets.sequentialServer;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DateClient {
  public static void main(String[] args) throws IOException {
    String port = "127.0.0.1";

    var socket = new Socket(port, 59090);
    var in = new Scanner(socket.getInputStream());
    System.out.println("Server response: " + in.nextLine());
  }
}
