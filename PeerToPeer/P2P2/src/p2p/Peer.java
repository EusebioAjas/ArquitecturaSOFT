package p2p;

import java.util.Scanner;

//Emitir votos
public class Peer {

  Forwarder forwarder = new Forwarder();

  public void service() {
    Scanner scanner = new Scanner(System.in);
    String input;
    boolean isListening = true;
    while (isListening) {
      input = scanner.nextLine();
      forwarder.sendMsg(input);
    }
  }
}
