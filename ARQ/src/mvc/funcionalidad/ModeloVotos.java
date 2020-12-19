package mvc.funcionalidad;

import java.util.ArrayList;
import java.util.List;

public class ModeloVotos implements Observable{
  private List<Candidato> candidatos;
  private List<Observador> observadores;

  public ModeloVotos() {
    this.candidatos = new ArrayList<>();
    this.observadores = new ArrayList<>();
  }

  public Candidato getCandidato(String nombre) {
    return candidatos.stream()
            .filter(c -> c.getNombre().equals(nombre))
            .findFirst()
            .orElse(null);
  }

  public void addCandidato(Candidato candidato) {
    candidatos.add(candidato);
  }

  @Override
  public synchronized void addObservador(Observador o) {
    if(o == null){
      throw new NullPointerException();
    }else{
      observadores.add(o);
    }
  }

  @Override
  public synchronized void eliminarObservador(Observador o) {
    if(o == null){
      throw  new NullPointerException();
    }else{
      observadores.remove(o);
    }
  }

  @Override
  public void notificarTodos() {
    observadores.forEach(o -> o.actualizar(candidatos));
  }

  public List<Candidato> getCandidatos() {
    return candidatos;
  }

  public List<Observador> getObservadores() {
    return observadores;
  }
}
