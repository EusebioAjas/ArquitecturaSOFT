package p2p;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Receiver {
  private ServerSocket serverSocket;
  private Socket socket;
  private InputStream input;
  private Scanner in;

  public Receiver(int port) {
    try {
      serverSocket = new ServerSocket(port);
      System.out.println("Server started");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String receiver() {
    String line = null;
    try {
      socket = serverSocket.accept();
      input = socket.getInputStream();
      in = new Scanner(input);
      line = in.nextLine();
    } catch (IOException e) {
      System.out.println("Error" + e);
    }
    return line;
  }

  public String unmarshal(String data) {
    String msg = data;
    System.out.printf(String.format("%s ", msg));
    return msg;
  }

  public void closeAllsockets() throws IOException {
    input.close();
    socket.close();
    serverSocket.close();
    in.close();
  }

  public String receiveMsg() throws IOException {
    if (unmarshal(receiver()).isEmpty()) {
      closeAllsockets();
    }
    return unmarshal(receiver());
  }
}
