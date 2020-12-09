package capasafter.com;

import java.util.Scanner;

public class Entrada implements IComponenteCapa {
  private String texto;

  @Override
  public String obtenerSalida() {
    return texto;
  }

  @Override
  public void ejecutarProceso(Object object) {
    System.out.println(object);
    this.texto = new Scanner(System.in).nextLine();
  }

  @Override
  public void mostrar() {
    System.out.println(texto);
  }
}
