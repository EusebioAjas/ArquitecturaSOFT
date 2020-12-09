package pipeAndFilters;

import pipeAndFilters.kwick.Alfabetizador;
import pipeAndFilters.kwick.Combinador;
import pipeAndFilters.kwick.Separador;
import pipeAndFilters.tuberiasyfiltros.Filtro;
import pipeAndFilters.tuberiasyfiltros.Tuberia;

import java.util.List;


public class Cliente {
  public static void main(String[] args) {

    Filtro filtroSeparador = new Separador();
    Tuberia tuberia = new Tuberia(filtroSeparador);
    tuberia.transferirDato("La casa Azul");

    filtroSeparador.leerDato(tuberia);
    filtroSeparador.transformarDato();
    filtroSeparador.jalarDato();

    Filtro filtroCombinador = new Combinador();
    filtroSeparador.setTuberiaSalida(new Tuberia(filtroCombinador));

    filtroCombinador.leerDato(filtroSeparador.obtenerDato());
    filtroCombinador.transformarDato();
    filtroCombinador.jalarDato();

    Filtro filtroAlfabetizador = new Alfabetizador();
    filtroCombinador.setTuberiaSalida(new Tuberia(filtroAlfabetizador));

    filtroAlfabetizador.leerDato(filtroCombinador.obtenerDato());
    filtroAlfabetizador.transformarDato();
    filtroAlfabetizador.jalarDato();

    List<String> p = (List<String>) filtroAlfabetizador.obtenerDato();

    p.forEach(System.out::println);
  }
}
