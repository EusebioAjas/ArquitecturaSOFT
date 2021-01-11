package model;

import java.util.HashMap;

public class Registry {
  public HashMap<String, Entry> registry = new HashMap<>();

  public void put(String client, Entry entry) {
    registry.put(client, entry);
  }

  public Entry getEntryByKey(String client) {
    return registry.get(client);
  }

  public HashMap<String, Entry> getRegistry() {
    return registry;
  }
}
