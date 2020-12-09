package pipeAndFiltersAfter;

import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {

    String entrada = new Scanner(System.in).nextLine();

    Tuberia tuberiaSalidaPrincipal = new Tuberia(entrada);
    Filtro seperador = new Separador();
    tuberiaSalidaPrincipal.siguienteFiltro(seperador);

    Tuberia tuberiaIntermedia1 = new Tuberia(seperador.getDatoSalida());
    Filtro combinador = new Combinador();
    tuberiaIntermedia1.siguienteFiltro(combinador);

    Tuberia tuberiaIntemedia2 = new Tuberia(combinador.getDatoSalida());
    Filtro alfabetizador = new Alfabetizador();
    tuberiaIntemedia2.siguienteFiltro(alfabetizador);

    Tuberia tuberiaSalidaFinal = new Tuberia(alfabetizador.getDatoSalida());
    System.out.println(tuberiaSalidaFinal.getDato());
  }
}
