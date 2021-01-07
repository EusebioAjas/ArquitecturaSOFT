package model;

import java.util.HashMap;

public class Registry {
  public HashMap<String, Entry> registry = new HashMap<>();

  public void putEntry(String client, Entry entry) {
    registry.put(client, entry);
  }

  public Entry getEntrybyKey(String client) {
    return registry.get(client);
  }

  public HashMap<String, Entry> getRegistry() {
    return registry;
  }
}
