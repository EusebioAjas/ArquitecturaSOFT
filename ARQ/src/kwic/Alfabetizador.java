package kwic;

import java.util.List;

public class Alfabetizador{
  List<List<String>> combinaciones;

  public Alfabetizador(List<List<String>> combinaciones) {
    this.combinaciones = combinaciones;
  }

  public void ordenar(){
    getCombinacionesOrdenadas().sort((str1, str2) -> str1.get(0).compareToIgnoreCase(str2.get(0)));
  }

  public List<List<String>> getCombinacionesOrdenadas(){
    return combinaciones;
  }

}
