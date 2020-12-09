package capaskwic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinador{
  private List<List<String>> conjuntoPalabras;
  private static final int PRIMER_ELMENTO = 0;

  public Combinador() {
    this.conjuntoPalabras = new LinkedList<>();
  }

  public void generarCombinaciones(List<String> palabras) {
    if (palabras != null) {
      conjuntoPalabras.add(getCombinacion(palabras));
      for (int i = 0; i < palabras.size() - 1; i++) {
        String palabra = palabras.remove(PRIMER_ELMENTO);
        palabras.add(palabra);
        conjuntoPalabras.add(getCombinacion(palabras));
      }
    }
  }

  private List<String> getCombinacion(List<String> lista) {
    List<String> nvaLista = new ArrayList<>();
    for (int i = 0; i < lista.size(); i++) {
      nvaLista.add(lista.get(i));
    }
    return nvaLista;
  }

  public List<List<String>> getSalida() {
    return conjuntoPalabras;
  }

  public void mostrarDatosCombinados() {
    System.out.println("\nCombinaciones: ");
    conjuntoPalabras.forEach(System.out::println);
  }
}
