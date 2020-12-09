package pyf;

public abstract class Filtro {
  Tuberia tuberiaSalida;
  public abstract void datoEntrada(Object object);
  public abstract void transformarDato();
  public abstract Object getDatoSalida();

  public void escribirDatoTuberiaSalida(){
    tuberiaSalida = new Tuberia(getDatoSalida());
  }

  public Tuberia getTuberiaSalida() {
    return tuberiaSalida;
  }
}
