package sockets.threadServer.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeCliente {
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.out.println("pass the server IP as the sole command line argument");
      return;
    }

    try (var socket = new Socket(args[0], 59898)) {
      System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
      var scanner = new Scanner(System.in);
      var in = new Scanner(socket.getInputStream());
      var out = new PrintWriter(socket.getOutputStream());
      while (scanner.hasNextLine()) {
        out.println(scanner.nextLine());
        System.out.println(in.nextLine());
      }
    }
  }
}
