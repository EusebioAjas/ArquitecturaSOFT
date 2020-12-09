package pipeAndFilters.kwick;

import pipeAndFilters.tuberiasyfiltros.Filtro;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Separador extends Filtro{

  private List<String> palabras = new ArrayList<>();
  private String palabra;

  @Override
  public void leerDato(Object object) {
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
  public Object obtenerDato() {
    return palabras;
  }
}
