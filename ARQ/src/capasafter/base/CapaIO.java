package capasafter.base;

import java.util.List;

public class CapaIO {
  private Entrada entrada = new Entrada();
  private CapaProceso capaProceso = new CapaProceso();
  private Salida salida = new Salida();

  public void generarEntrada(){
    entrada.introducirTexto();
    capaProceso.ejecutarProcesos(getEntradaProceso());
  }

  public void mostrarSalida(){
    procesarSalida(capaProceso.getSalidaProceso());
    salida.mostrarSalida();
  }

  private String getEntradaProceso() {
    return entrada.getPalabras();
  }

  private void procesarSalida(List<List<String>> lista) {
    salida.convertirListaACadena(lista);
  }
}
