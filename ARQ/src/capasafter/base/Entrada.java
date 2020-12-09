package capasafter.base;

import java.util.Scanner;

public class Entrada {
  private String palabras;

  public void introducirTexto(){
    palabras = new Scanner(System.in).nextLine();
  }

  public String getPalabras() {
    return palabras;
  }
}
