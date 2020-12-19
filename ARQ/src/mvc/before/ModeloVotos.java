package mvc.before;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModeloVotos {
  private static List<Candidato> candidatos = new ArrayList<>();
  private static List<Observador> observadores = new ArrayList<>();

  public List<Candidato> getCandidatos() {
    return Collections.unmodifiableList(candidatos);
  }

  public List<Observador> getObservadores() {
    return Collections.unmodifiableList(observadores);
  }

  public void addCandidato(Candidato candidato){
    candidatos.add(candidato);
  }

  public void removeCandidato(Candidato candidato){
    candidatos.remove(candidato);
  }

  public void addObservador(Observador obs){
    observadores.add(obs);
  }

  public void removeObservador(Observador obs){
    observadores.remove(obs);
  }
}
