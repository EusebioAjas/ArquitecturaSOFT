package model;

public class Configuration {
  private Registry registry;

  public Configuration() {
    Entry entry = new Entry("localhost", 1111);
    registry = new Registry();
    registry.putEntry("Client", entry);
    entry = new Entry("localhost", 2222);
    registry.putEntry("Server", entry);
  }

  public Entry getEntryByKey(String key) {
    return registry.getEntrybyKey(key);
  }
}
