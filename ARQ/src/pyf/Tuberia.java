package pyf;

public class Tuberia {
  private Object dato;

  public Tuberia(Object data) {
    this.dato = data;
  }

  public void transferirDato(Filtro filtro){
    if(filtro != null){
      filtro.datoEntrada(dato);
    }
  }

  public Object getDato() {
    return dato;
  }
}
