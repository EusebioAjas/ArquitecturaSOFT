package capasafter.com;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separador implements IComponenteCapa {

  private List<String> palabras = new ArrayList<>();

  @Override
  public List<String> obtenerSalida() {
    return palabras;
  }

  @Override
  public void ejecutarProceso(Object object) {
    StringTokenizer tokens = new StringTokenizer((String) object);
    while (tokens.hasMoreTokens()) {
      palabras.add(tokens.nextToken());
    }
  }

  @Override
  public void mostrar() {
    System.out.println("\nSeparación:\n" + palabras);
  }
}
