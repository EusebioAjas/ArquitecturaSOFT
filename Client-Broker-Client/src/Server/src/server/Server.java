package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
  private static final int PORT = 59090;
  private static final String IP_ADDRESS = "127.0.0.1";

  public static void main(String[] args) throws IOException {
    /*try(var listener = new ServerSocket(PORT)){
      System.out.println("The date server is running...");
      while (true){
        try(var socket = listener.accept()){
          var out = new PrintWriter(socket.getOutputStream(), true);
          out.println();
        }
      }
    }*/

    var socket = new Socket(IP_ADDRESS, PORT);
    var in = new Scanner(socket.getInputStream());
    System.out.printf("Server response: " + in.nextLine());
  }

  private static void response() throws IOException {

  }
}
