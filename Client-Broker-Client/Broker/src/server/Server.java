package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {
  private static final int PORT = 59090;
  private static final String IP_ADDRESS = "127.0.0.1";

  public static void main(String[] args) throws IOException {
    try (var listener = new ServerSocket(PORT)) {
      System.out.println("The broker is running...");
      while (true) {
        try (var socket = listener.accept()) {
          var in = new Scanner(socket.getInputStream());
          var out = new PrintWriter(socket.getOutputStream(), true);
          out.println(in);
          while (in.hasNextLine()){
            System.out.println("send: " + in.nextLine());
          }
        }
      }
    }
  }
}
