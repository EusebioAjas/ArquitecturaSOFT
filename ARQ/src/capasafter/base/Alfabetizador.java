package capasafter.base;

import java.util.List;

public class Alfabetizador{
  private List<List<String>> combinaciones;

  public void ordenar(List<List<String>> combinaciones) {
    this.combinaciones = combinaciones;
    combinaciones.sort((str1, str2) -> str1.get(0).compareToIgnoreCase(str2.get(0)));
  }

  public List<List<String>> getSalida() {
    return combinaciones;
  }

  public void mostrarDatosOrdenados() {
    System.out.println("\nOrdenamiento: ");
    combinaciones.forEach(System.out::println);
  }
}
