package kwic;

import java.util.*;

public class Separador implements Proceso{
  private List<String> palabras = new ArrayList<>();

  public void separarPalabra(String palabra) {
    StringTokenizer tokens = new StringTokenizer(palabra);
    while (tokens.hasMoreTokens()) {
      palabras.add(tokens.nextToken());
    }
  }

  @Override
  public List<String> obtenerSalida() {
    return palabras;
  }

  @Override
  public void mostrarSalida() {
    System.out.println("\nSeparación:\n" + palabras);
  }
}
