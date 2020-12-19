package mvc.funcionalidad;

import java.util.Observable;
import java.util.Observer;

public class Cliente  {

  public Cliente() {

    ModeloVotos modeloVotos = new ModeloVotos();
    try {
      Candidato joe = new Candidato("Joe");
      Candidato lisa = new Candidato("Lisa");
      Candidato mike = new Candidato("Mike");

      modeloVotos.addCandidato(joe);
      modeloVotos.addCandidato(lisa);
      modeloVotos.addCandidato(mike);

      modeloVotos.addObservador(new GraficaCircular());
      modeloVotos.addObservador(new GraficaBarras());

      joe.incrementarVoto();
      joe.incrementarVoto();
      lisa.incrementarVoto();
      modeloVotos.notificarTodos();
      System.out.println(modeloVotos.getCandidatos());
      Thread.sleep(2000);
      lisa.incrementarVoto();
      lisa.incrementarVoto();
      joe.incrementarVoto();
      modeloVotos.notificarTodos();
      System.out.println(modeloVotos.getCandidatos());
      Thread.sleep(2000);
      mike.incrementarVoto();
      mike.incrementarVoto();
      mike.incrementarVoto();
      joe.incrementarVoto();
      lisa.incrementarVoto();
      modeloVotos.notificarTodos();
      System.out.println(modeloVotos.getCandidatos());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }


  public static void main(String[] args) {
    new Cliente();
  }
}
