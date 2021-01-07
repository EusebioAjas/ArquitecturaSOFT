package p2p;

import java.io.IOException;

public class ReceiverThread implements Runnable {
  public Thread thread;
  private Receiver receiver;

  public ReceiverThread(String threadname, int port) {
    thread = new Thread(this, threadname);
    receiver = new Receiver(port);
    System.out.printf("New Thread, %s on port %d\n", threadname, port);
    thread.start();
  }

  @Override
  public void run() {
    try {
      String result = receiver.receiveMsg();
      while (result != null) {
        result = receiver.receiveMsg();
        System.out.println(result);
      }
      receiver.closeAllsockets();
    } catch (IOException | NullPointerException e) {
      System.out.println(e);
    }
  }

}
