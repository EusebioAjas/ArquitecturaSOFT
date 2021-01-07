package model;

public class Configuration {
  private Registry reg;

  public Configuration() {
    Entry entry = new Entry("localhost", 2222);
    reg = new Registry();
    reg.putEntry("Client", entry);
    entry = new Entry("localhost", 1111);
    reg.putEntry("Server", entry);
  }

  public Registry getReg() {
    return reg;
  }
}
