package kwic;

public class Kwic {
  private Entrada entrada = new Entrada();
  private Salida salida = new Salida();

  public void ejecutar() {
    entrada.introducirTexto();
    Separador separador = new Separador();
    separador.separarPalabra(entrada.getPalabras());
    separador.mostrarProceso();
    Combinador combinador = new Combinador();
    combinador.generarCombinaciones(separador.getPalabras());
    combinador.mostrarProceso();
    Alfabetizador alfabetizador = new Alfabetizador(combinador.getConjuntoPalabras());
    alfabetizador.ordenar();
    alfabetizador.mostrarProceos();
    salida.convertirListaACadena(alfabetizador.getCombinacionesOrdenadas());
    salida.mostrarSalida();
  }
}
