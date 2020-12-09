package pipeAndFilters.tuberiasyfiltros;

public abstract class Filtro {
  private Tuberia tuberiaSalida;

  public void setTuberiaSalida(Tuberia tuberia){
    this.tuberiaSalida = tuberia;
  }

  public abstract void leerDato(Object object);

  public abstract void  transformarDato();

  public abstract Object obtenerDato();

  public void jalarDato() {
    if(tuberiaSalida != null){
      tuberiaSalida.transferirDato(obtenerDato());
    }
  }

}
