package capasafter.com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Salida implements IComponenteCapa {
  private List<String> cadenas = new ArrayList<>();

  @Override
  public List<String> obtenerSalida() {
    return cadenas;
  }

  @Override
  public void ejecutarProceso(Object object) {
    List<List<String>> conjuntoPalabras = (List<List<String>>) object;
    conjuntoPalabras.forEach(cadena -> {
      String result = cadena.stream()
              .map(String::valueOf)
              .collect(Collectors.joining(" "));
      cadenas.add(result);
    });
  }

  @Override
  public void mostrar() {
    System.out.println("\nSalida: ");
    cadenas.forEach(System.out::println);
  }
}
