package model;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Forwarder {
  private Socket socket;
  private OutputStream outputStream;
  private String forwarderName;
  private Configuration config;
  private Entry entry;

  public Forwarder(String forwarderName) {
    this.forwarderName = forwarderName;
    config = new Configuration();
    entry = config.getEntryByKey(this.forwarderName);
  }

  private byte[] marshal(Message message) {
    return message.getData().getBytes();
  }

  public void deliver(String theDest, byte[] data) {
    entry.setIp(theDest);
    try {
      socket = new Socket(entry.getIp(), entry.getPort());
      System.out.println("Listening on port " + entry.getPort());
      outputStream = socket.getOutputStream();
      outputStream.write(data);
      outputStream.flush();
      outputStream.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  public void sendMessage(String theDest, Message theMsg) {
    entry.setIp(theDest);
    System.out.println("Message deliver is " + theMsg + " port " + entry.getPort());
    deliver(entry.getIp(), marshal(theMsg));
  }

  public Entry getEntry() {
    return entry;
  }
}
