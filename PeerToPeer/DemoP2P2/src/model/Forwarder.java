package model;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Forwarder {
  private Socket socketSalida;
  private OutputStream streamSalida;
  private String forwarderName;
  private Configuration config;

  public Forwarder(String _theForwardername) {
    this.forwarderName = _theForwardername;
    setEntrySocket(forwarderName);
  }

  private void setEntrySocket(String theDorwardname) {
    config = new Configuration();
    Entry entry = config.getReg().getEntrybyKey(theDorwardname);
    String ip = entry.getIp();
    int port = entry.getPort();
    try {
      socketSalida = new Socket(ip, port);
      streamSalida = socketSalida.getOutputStream();
      System.out.println("The server is conneted on port: " + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private byte[] marshal(Message theMsg) {
    return theMsg.getData().getBytes();
  }

  private void deliver(String theDest, byte[] data) {
    this.forwarderName = theDest;
    try {
      setEntrySocket(forwarderName);
      streamSalida.write(data);
      streamSalida.flush();
      streamSalida.close();
      socketSalida.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void sendMsg(String theDest, Message theMsg) {
    deliver(theDest, marshal(theMsg));
  }

}
