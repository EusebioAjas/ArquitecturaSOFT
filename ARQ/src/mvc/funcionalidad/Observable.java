package mvc.funcionalidad;

public interface Observable {
  void addObservador(Observador o);
  void eliminarObservador(Observador o);
  void notificarTodos();
}
