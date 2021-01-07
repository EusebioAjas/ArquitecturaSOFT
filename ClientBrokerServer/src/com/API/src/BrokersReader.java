package com.API.src;

import com.API.src.entidades.BrokerAdrr;
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class BrokersReader {
  private static String PATH = "src/com/API/src/files/brokers.json";
  private static int DEAFAULT_PORT = 5555;

  public static HashMap<String, BrokerAdrr> loadBrokers() {
    Gson gson = new Gson();
    BrokerAdrr[] result;
    HashMap<String, BrokerAdrr> knownBrokers;

    try (BufferedReader json = new BufferedReader(new FileReader(PATH))) {
      JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
      JsonArray brokers = jsonObject.getAsJsonArray("brokers");
      result = gson.fromJson(brokers, BrokerAdrr[].class);
      knownBrokers = new HashMap<>();
      for (BrokerAdrr currBroker : Arrays.asList(result)) {
        knownBrokers.put(currBroker.getName(), currBroker);
      }
    } catch (IOException e) {
      System.err.println(e.getMessage());
      System.out.println("Loading backup information...");
      knownBrokers = loadBackupInfo();
    }
    return knownBrokers;
  }

  private static HashMap<String, BrokerAdrr> loadBackupInfo() {
    HashMap<String, BrokerAdrr> backupBrokersInfo;
    backupBrokersInfo = new HashMap<>();
    backupBrokersInfo.put("1", new BrokerAdrr("1", "localhost", DEAFAULT_PORT));
    return backupBrokersInfo;
  }
}
