package mvc.funcionalidad;

import java.util.UUID;

public class Candidato {
  private String id;
  private String nombre;
  private int numVotos;

  public Candidato(String nombre) {
    this.nombre = nombre;
    this.id = UUID.randomUUID().toString();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getNumVotos() {
    return numVotos;
  }

  public void setNumVotos(int numVotos) {
    this.numVotos = numVotos;
  }

  public void incrementarVoto(){
    this.numVotos++;
  }

  @Override
  public String toString() {
    String formato = "Nombre: %s [%d]";
    return String.format(formato, getNombre(), getNumVotos());
  }
}
