package kwic;

public class Cliente {

  public Cliente() {
    Kwic kwic = new Kwic();
    kwic.ejecutar();
  }

  public static void main(String[] args) {
    new Cliente();
  }
}
