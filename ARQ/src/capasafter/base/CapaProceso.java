package capasafter.base;

import java.util.List;

public class CapaProceso {
  private Separador separador = new Separador();
  private Combinador combinador = new Combinador();
  private Alfabetizador alfabetizador = new Alfabetizador();

  public void ejecutarProcesos(String palabra){
    separador.separarPalabra(palabra);
    separador.mostrarDatosSeparados();

    combinador.generarCombinaciones(separador.getSalida());
    combinador.mostrarDatosCombinados();

    alfabetizador.ordenar(combinador.getSalida());
    alfabetizador.mostrarDatosOrdenados();
  }

  public List<List<String>> getSalidaProceso(){
    return alfabetizador.getSalida();
  }
}
