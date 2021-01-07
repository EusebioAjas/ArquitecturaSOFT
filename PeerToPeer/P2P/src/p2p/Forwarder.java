package p2p;

import config.PeerInfo;
import config.PeerManager;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Forwarder {

  private Socket socket;
  private OutputStream output;
  private PrintWriter socketOutput;
  private PeerInfo peerInfo;

  public Forwarder() {
    this.peerInfo = PeerManager.getInstance().getDafaultPeer();
  }

  public String marshal(String msg) {
    return msg;
  }

  public void deliver(String data) {
    try {
      String ip = peerInfo.getIp();
      int port = Integer.parseInt(peerInfo.getPort());

      socket = new Socket(ip, port);
      output = socket.getOutputStream();
      socketOutput = new PrintWriter(output, true);

      System.out.println();
      socketOutput.println(data + ", " + peerInfo.getServiceName());
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
  }

  public void sendMsg(String msg) {
    System.out.printf(String.format("%s ", msg));
    deliver(marshal(msg));
  }
}
