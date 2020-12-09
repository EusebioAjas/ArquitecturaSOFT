package capasafter.com;

public class CapaProceso extends Capa {
  private IComponenteCapa separador;
  private IComponenteCapa combinador;
  private IComponenteCapa alfabetizador;

  public CapaProceso() {
    this.separador = new Separador();
    this.combinador = new Combinador();
    this.alfabetizador = new Alfabetizador();
  }

  @Override
  Object obtenerSalidaProceso(Object object) {
    separador.ejecutarProceso(object);
    separador.mostrar();

    combinador.ejecutarProceso(separador.obtenerSalida());
    combinador.mostrar();

    alfabetizador.ejecutarProceso(combinador.obtenerSalida());
    alfabetizador.mostrar();

    return alfabetizador.obtenerSalida();
  }
}
