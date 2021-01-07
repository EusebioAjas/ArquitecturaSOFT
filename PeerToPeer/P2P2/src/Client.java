import p2p.Peer;
import p2p.ReceiverThread;

import java.io.IOException;

public class Client {
  public static void main(String[] args) throws IOException {
    new ReceiverThread("Peer2", 5200);
    new Peer().service();
  }
}
