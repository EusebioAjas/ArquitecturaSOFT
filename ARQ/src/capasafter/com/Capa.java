package capasafter.com;

public abstract class Capa {
  private Capa siguienteCapa;

  public void setSiguienteCapa(Capa siguienteCapa) {
    this.siguienteCapa = siguienteCapa;
  }

  abstract Object obtenerSalidaProceso(Object object);

  public void ejecutarProcesoCapa(Object object) {
    Object datos = obtenerSalidaProceso(object);
    if (siguienteCapa != null) {
      siguienteCapa.ejecutarProcesoCapa(datos);
    }
  }
}
