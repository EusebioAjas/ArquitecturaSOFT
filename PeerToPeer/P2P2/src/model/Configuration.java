package model;

public class Configuration {
  private Registry registry;

  public Configuration() {
    registry = new Registry();

    Entry entry = new Entry("127.0.0.1", 1111);
    registry.put("Peer1", entry);

    entry = new Entry("127.0.0.1", 2222);
    registry.put("Peer2", entry);
  }

  public Entry getEntryByKey(String client) {
    return registry.getEntryByKey(client);
  }
}
