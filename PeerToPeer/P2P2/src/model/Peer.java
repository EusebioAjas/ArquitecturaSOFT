package model;

import java.util.Scanner;

public class Peer implements Runnable {
  private Forwarder forwarder;
  private Receiver receiver;
  private Message result;

  public Peer() {
    Thread thread = new Thread("Peer2");
    System.out.println("the thread" + thread);
    thread.start();
  }

  @Override
  public void run() {
    forwarder = new Forwarder("Peer2");
    receiver = new Receiver("Peer2");
    while (true) {
      result = receiver.receiveMsg();
      Message msg = new Message("Peer2", new Scanner(System.in).nextLine());
      forwarder.sendMessage(result.getSender(), msg);
    }
  }

}
