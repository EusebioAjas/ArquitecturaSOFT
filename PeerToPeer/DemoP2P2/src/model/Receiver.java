package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
  private ServerSocket socketServer;
  private Socket salidaSocket;
  private InputStream entradaStream;
  private String receiverName;
  private Configuration config;

  public Receiver(String theName) {
    this.receiverName = theName;
    setEntrySocketServer(theName);
  }

  private void setEntrySocketServer(String theName) {
    config = new Configuration();
    Entry entry = config.getReg().getEntrybyKey(theName);
    int port = entry.getPort();
    try {
      socketServer = new ServerSocket(port);
      System.out.println("Listening on port: " + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Message unmarshal(byte[] infoInArrayFormat) {
    String mensaje = new String(infoInArrayFormat);
    System.out.println("message: " + mensaje);
    return new Message(receiverName, mensaje);
  }

  private byte[] receive() {
    //user la función InputStream.read() para leer los bytes
    byte[] buffer = null;
    try {
      salidaSocket = socketServer.accept();
      entradaStream = salidaSocket.getInputStream();
      int val = entradaStream.read();
      buffer = new byte[val];
      entradaStream.read(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return buffer;
  }

  public Message receiveMsg() {
    return unmarshal(receive());
  }

}
