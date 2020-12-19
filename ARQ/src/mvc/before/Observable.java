package mvc.before;

public interface Observable {
  void agregarObservador(Observador observador);

  void eliminarObservador(Observador observador);

  void notificarTodos();
}