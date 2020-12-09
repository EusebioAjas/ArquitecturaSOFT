package pipeAndFiltersAfter;

public interface Filtro {
  void setDatoEntrada(Object object);

  void transformarDato();

  Object getDatoSalida();

}
