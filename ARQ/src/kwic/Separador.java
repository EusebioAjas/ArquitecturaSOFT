package kwic;

import java.util.*;

public class Separador {
  private List<String> palabras = new ArrayList<>();

  public void separarPalabra(String palabra) {
    StringTokenizer tokens = new StringTokenizer(palabra);
    while (tokens.hasMoreTokens()) {
      palabras.add(tokens.nextToken());
    }
  }

  public List<String> getPalabras() {
    return palabras;
  }

  public void mostrarProceso() {
    System.out.println("\nSeparación:\n" + palabras);
  }
}
