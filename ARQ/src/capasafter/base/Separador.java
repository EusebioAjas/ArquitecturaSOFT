package capasafter.base;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separador{
  private List<String> palabras = new ArrayList<>();

  public void separarPalabra(String palabra) {
    StringTokenizer tokens = new StringTokenizer(palabra);
    while (tokens.hasMoreTokens()) {
      palabras.add(tokens.nextToken());
    }
  }

  public List<String> getSalida() {
    return palabras;
  }

  public void mostrarDatosSeparados() {
    System.out.println("\nSeparación:\n" + palabras);
  }
}
