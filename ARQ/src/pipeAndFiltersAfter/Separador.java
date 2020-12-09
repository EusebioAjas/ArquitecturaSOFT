package pipeAndFiltersAfter;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separador implements Filtro {

  private List<String> palabras = new ArrayList<>();
  private String palabra;

  @Override
  public void setDatoEntrada(Object object) {
    palabra = (String) object;
  }

  @Override
  public void transformarDato() {
    StringTokenizer tokens = new StringTokenizer(palabra);
    while (tokens.hasMoreTokens()) {
      palabras.add(tokens.nextToken());
    }
  }

  @Override
  public Object getDatoSalida() {
    return palabras;
  }

}
