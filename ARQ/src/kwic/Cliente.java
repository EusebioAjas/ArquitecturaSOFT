package kwic;

public class Cliente {
  public static void main(String[] args) {
    Entrada entrada = new Entrada();
    entrada.introducirTexto();
    Separador separador = new Separador();
    separador.separarPalabra(entrada.getPalabras());
    Combinador combinador = new Combinador();

    System.out.println("\nSeparación");
    System.out.println(separador.getPalabras());

    System.out.println("\nCombinaciones");
    combinador.generarCombinaciones(separador.getPalabras());
    combinador.getConjuntoPalabras().forEach(System.out::println);

    System.out.println("\nOrdenado");
    Alfabetizador alfa = new Alfabetizador(combinador.getConjuntoPalabras());
    alfa.ordenar();
    alfa.getCombinacionesOrdenadas().forEach(System.out::println);

    Salida salida =  new Salida();
    System.out.println("\nSalida");
    salida.mostrarSalida(alfa.getCombinacionesOrdenadas());
  }
}
