package pipeAndFilters.kwick;

import pipeAndFilters.tuberiasyfiltros.Filtro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alfabetizador  extends Filtro {
  private List<List<String>> combinaciones;

  @Override
  public void leerDato(Object object) {
    this.combinaciones = (List<List<String>>) object;
  }

  @Override
  public void transformarDato() {
    combinaciones.sort((str1, str2) -> str1.get(0).compareToIgnoreCase(str2.get(0)));
  }

  @Override
  public List<String> obtenerDato() {
    List<String> cadenas = new ArrayList<>();
    combinaciones.forEach(cadena -> {
      String result = cadena.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" "));
      cadenas.add(result);
    });
    return cadenas;
  }
}
