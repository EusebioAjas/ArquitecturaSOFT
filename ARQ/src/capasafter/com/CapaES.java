package capasafter.com;

public class CapaES extends Capa {
  private IComponenteCapa entrada;
  private IComponenteCapa salida;

  public CapaES() {
    this.entrada = new Entrada();
    this.salida = new Salida();
  }

  public void ejecutarCapaES(){
    entrada.ejecutarProceso("Entrada: ");
    this.ejecutarProcesoCapa(entrada.obtenerSalida());
  }

  @Override
  Object obtenerSalidaProceso(Object object) {
    Capa capaProceso = new CapaProceso();
    salida.ejecutarProceso(capaProceso.obtenerSalidaProceso(object));
    salida.mostrar();
    return salida.obtenerSalida();
  }
}
