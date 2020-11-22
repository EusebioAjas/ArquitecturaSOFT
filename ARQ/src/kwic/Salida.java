package kwic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salida {

  public void mostrarSalida(List<List<String>> combinaciones) {
    List<String> cadenas = new ArrayList<>();

    combinaciones.forEach(cadena -> {
      String result = cadena.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" "));
      cadenas.add(result);
    });

    cadenas.forEach(System.out::println);
  }
}
