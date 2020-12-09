package capaskwic;

public class Cliente {
  public Cliente() {
    Capa capaSuperior = new Capa();
    capaSuperior.generarEntrada();
    capaSuperior.mostrarSalida();
  }

  public static void main(String[] args) {
    new Cliente();
  }
}
