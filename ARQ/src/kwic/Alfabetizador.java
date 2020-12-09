package kwic;

import java.util.List;

public class Alfabetizador implements Proceso{
  private List<List<String>> combinaciones;

  public void ordenar(List<List<String>> combinaciones) {
    this.combinaciones = combinaciones;
    combinaciones.sort((str1, str2) -> str1.get(0).compareToIgnoreCase(str2.get(0)));
  }

  @Override
  public List<List<String>> obtenerSalida() {
    return combinaciones;
  }

  @Override
  public void mostrarSalida() {
    System.out.println("\nOrdenamiento: ");
    combinaciones.forEach(System.out::println);
  }
}
