package kwic;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
  public static void main(String[] args) {
    List<Integer> intList = Arrays.asList(1, 2, 3);
    String result = intList.stream()
            .map(n -> String.valueOf(n))
            .collect(Collectors.joining(" "));

    System.out.println(result);

  }

  public static List<String> combinar(List<String> lista){
    List<String> nvaLista = new ArrayList<>();
    for(int i= 0; i< lista.size(); i++){
      nvaLista.add(lista.get(i));
    }
    return nvaLista;
  }
}
