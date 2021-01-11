package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {

  private ServerSocket serverSocket;
  private Socket socket;
  private InputStream inputStream;
  private String receiverName;
  private Forwarder forwarder;

  public Receiver(String receiverName) {
    this.receiverName = receiverName;
    forwarder = new Forwarder(this.receiverName);
    try {
      int port = forwarder.getEntry().getPort();
      serverSocket = new ServerSocket(port);
      System.out.println("Server started on port " + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Message unmarshall(byte[] infoInArrayFormat) {
    String message = new String(infoInArrayFormat);
    System.out.println("message: " + message);
    return new Message(forwarder.getEntry().getIp(), message);
  }

  private byte[] receive() {
    byte[] buffer = null;
    try {
      socket = serverSocket.accept();
      inputStream = socket.getInputStream();
      int val = inputStream.read();
      buffer = new byte[val];
      inputStream.read(buffer);
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    return buffer;
  }

  public Message receiveMsg() {
    return unmarshall(receive());
  }

}
