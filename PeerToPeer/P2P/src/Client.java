import p2p.Peer;
import p2p.ReceiverThread;

import java.io.IOException;

public class Client {
  public static void main(String[] args) throws IOException {
    new ReceiverThread("Peer1", 5500);
    new Peer().service();
  }
}
