package model;

import java.util.Scanner;

public class Peer implements Runnable {
  private Forwarder forwarder;
  private Receiver receiver;
  private Message result;

  public Peer() {
    Thread thread = new Thread("Peer1");
    System.out.println("the thread" + thread);
    thread.start();
  }

  @Override
  public void run() {
    forwarder = new Forwarder("Peer1");
    receiver = new Receiver("Peer1");
    result = receiver.receiveMsg();
    while (true) {
      Message msg = new Message("Peer1", new Scanner(System.in).nextLine());
      forwarder.sendMessage(result.getSender(), msg);
    }
  }
}
