package model;

import java.util.Scanner;

public class Peer extends Thread {
  Receiver receiver;
  Forwarder forwarder;

  @Override
  public void run() {
    forwarder = new Forwarder("Client");
    receiver = new Receiver("Server");
    Message result = receiver.receiveMsg();
    Scanner in = new Scanner(System.in);
    String message = "";
    while (true) {
      System.out.println("Ingrse texto: ");
      message = in.next();
      Message msg = new Message("Server", message);
      forwarder.sendMsg(result.getSender(), msg);
    }
  }

}
