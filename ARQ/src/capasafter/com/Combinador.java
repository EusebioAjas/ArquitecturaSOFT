package capasafter.com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinador implements IComponenteCapa {
  private List<List<String>> conjuntoPalabras;
  private static final int PRIMER_ELMENTO = 0;

  public Combinador() {
    this.conjuntoPalabras = new LinkedList<>();
  }

  private List<String> getCombinacion(List<String> lista) {
    List<String> nvaLista = new ArrayList<>();
    for (int i = 0; i < lista.size(); i++) {
      nvaLista.add(lista.get(i));
    }
    return nvaLista;
  }

  @Override
  public List<List<String>> obtenerSalida() {
    return conjuntoPalabras;
  }

  @Override
  public void ejecutarProceso(Object object) {
    List<String> palabras = (List<String>) object;
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
  public void mostrar() {
    System.out.println("\nCombinaciones: ");
    conjuntoPalabras.forEach(System.out::println);
  }
}
