package capasafter.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salida {
  private List<String> cadenas = new ArrayList<>();

  public void convertirListaACadena(List<List<String>> conjuntoPalabras) {
    conjuntoPalabras.forEach(cadena -> {
      String result = cadena.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" "));
      cadenas.add(result);
    });
  }

  public void mostrarSalida() {
    System.out.println("\nSalida: ");
    cadenas.forEach(System.out::println);
  }
}
