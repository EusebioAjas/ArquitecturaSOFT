package pipeAndFiltersAfter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinador implements Filtro {
  private List<List<String>> conjuntoPalabras;
  private List<String> palabrasProceso;
  private static final int PRIMER_ELMENTO = 0;

  public Combinador() {
    this.conjuntoPalabras = new LinkedList<>();
  }

  @Override
  public void setDatoEntrada(Object object) {
    palabrasProceso = (List<String>) object;
  }

  @Override
  public void transformarDato() {
    List<String> palabras = palabrasProceso;
    if (palabras != null) {
      conjuntoPalabras.add(getCombinacion(palabras));
      for (int i = 0; i < palabras.size() - 1; i++) {
        String palabra = palabras.remove(PRIMER_ELMENTO);
        palabras.add(palabra);
        conjuntoPalabras.add(getCombinacion(palabras));
      }
    }
  }

  @Override
  public Object getDatoSalida() {
    return conjuntoPalabras;
  }

  private List<String> getCombinacion(List<String> lista) {
    List<String> nvaLista = new ArrayList<>();
    for (int i = 0; i < lista.size(); i++) {
      nvaLista.add(lista.get(i));
    }
    return nvaLista;
  }
}
