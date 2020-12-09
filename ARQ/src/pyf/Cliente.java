package pyf;

public class Cliente {
  public static void main(String[] args) {

    Tuberia tuberia = new Tuberia("La casa Azul");

    Filtro separador = new Separador();
    tuberia.transferirDato(separador);
    separador.transformarDato();
    separador.escribirDatoTuberiaSalida();

    Filtro combinador = new Combinador();
    separador.getTuberiaSalida().transferirDato(combinador);
    combinador.transformarDato();
    combinador.escribirDatoTuberiaSalida();

    Filtro alfabetizador = new Alfabetizador();
    combinador.getTuberiaSalida().transferirDato(alfabetizador);
    alfabetizador.transformarDato();
    alfabetizador.escribirDatoTuberiaSalida();

    System.out.println(alfabetizador.getTuberiaSalida().getDato());

  }
}
