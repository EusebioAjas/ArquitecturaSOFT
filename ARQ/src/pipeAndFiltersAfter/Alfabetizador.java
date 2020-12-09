package pipeAndFiltersAfter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Alfabetizador implements Filtro {
  private List<List<String>> combinaciones;
  private String result = "";

  @Override
  public void setDatoEntrada(Object object) {
    this.combinaciones = (List<List<String>>) object;
  }

  @Override
  public void transformarDato() {
    combinaciones.sort((str1, str2) -> str1.get(0).compareToIgnoreCase(str2.get(0)));

    combinaciones.forEach(cadena -> {
      result += cadena.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" "));
      result += "\n";
    });
  }

  @Override
  public String getDatoSalida() {
    return result;
  }
}
