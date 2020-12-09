package kwic;

public class KWIC {
  private Entrada entrada = new Entrada();
  private Salida salida = new Salida();
  private Separador separador = new Separador();
  private Combinador combinador = new Combinador();
  private Alfabetizador alfabetizador = new Alfabetizador();

  public void ejecutar() {
    entrada.introducirTexto();

    separador.separarPalabra(entrada.getPalabras());
    separador.mostrarSalida();

    combinador.generarCombinaciones(separador.obtenerSalida());
    combinador.mostrarSalida();

    alfabetizador.ordenar(combinador.obtenerSalida());
    alfabetizador.mostrarSalida();

    salida.convertirListaACadena(alfabetizador.obtenerSalida());
    salida.mostrarSalida();
  }
}
