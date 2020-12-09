package kwic;

public class Cliente {

  public Cliente() {
    KWIC kwic = new KWIC();
    kwic.ejecutar();
  }

  public static void main(String[] args) {
    new Cliente();
  }
}
