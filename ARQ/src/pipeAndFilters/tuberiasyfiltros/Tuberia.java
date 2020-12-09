package pipeAndFilters.tuberiasyfiltros;

public class Tuberia {
  private Filtro filtro;
  public Tuberia(Filtro filtro) {
    this.filtro = filtro;
  }

  public void transferirDato(Object dato){
    filtro.leerDato(dato);
  }
}
