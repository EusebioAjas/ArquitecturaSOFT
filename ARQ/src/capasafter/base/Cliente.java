package capasafter.base;

public class Cliente {
  public Cliente() {
    CapaIO capaSuperior = new CapaIO();
    capaSuperior.generarEntrada();
    capaSuperior.mostrarSalida();
  }

  public static void main(String[] args) {
    new Cliente();
  }
}
