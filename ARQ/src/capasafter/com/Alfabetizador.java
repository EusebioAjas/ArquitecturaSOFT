package capasafter.com;

import java.util.List;

public class Alfabetizador implements IComponenteCapa {
  private List<List<String>> combinaciones;

  @Override
  public List<List<String>> obtenerSalida() {
    return combinaciones;
  }

  @Override
  public void ejecutarProceso(Object object) {
    this.combinaciones = (List<List<String>>) object;
    combinaciones.sort((str1, str2) -> str1.get(0).compareToIgnoreCase(str2.get(0)));
  }

  @Override
  public void mostrar() {
    System.out.println("\nOrdenamiento: ");
    combinaciones.forEach(System.out::println);
  }
}
