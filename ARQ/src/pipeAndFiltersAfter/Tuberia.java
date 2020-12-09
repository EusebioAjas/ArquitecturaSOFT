package pipeAndFiltersAfter;

public class Tuberia {
  private Object dato;
  private Filtro filtro;

  public Tuberia(Object dato) {
    this.dato = dato;
  }

  public void siguienteFiltro(Filtro filtro) {
    this.filtro = filtro;
    if (existeFiltro()) {
      filtro.setDatoEntrada(dato);
      filtro.transformarDato();
    }
  }

  public Object getDato() {
    return dato;
  }

  private boolean existeFiltro() {
    return filtro != null;
  }
}
