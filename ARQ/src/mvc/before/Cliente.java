package mvc.before;

public class Cliente {

  public static void main(String[] args) {
    ControladorVotos controladorVotos = new ControladorVotos();
    controladorVotos.agregarCandidato(new Candidato("Pepe"));
    controladorVotos.agregarCandidato(new Candidato("Lisa"));
    controladorVotos.agregarCandidato(new Candidato("Kike"));
    controladorVotos.agregarCandidato(new Candidato("Alicia"));

    controladorVotos.agregarObservador(new GraficaCircular());
    controladorVotos.agregarObservador(new GraficaBarras());
  }
}
