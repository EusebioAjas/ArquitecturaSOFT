package config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;

public class PeersLoader {
  private static String FILE_PATH = "src/files/peersInfo.json";

  public static HashMap<String, PeerInfo> loadPeersInfo() {
    Gson gson = new Gson();
    PeerInfo[] peersInfo;
    HashMap<String, PeerInfo> knowPeers = null;

    try {
      BufferedReader json = new BufferedReader(new FileReader(FILE_PATH));
      JsonObject peersObject = new JsonParser().parse(json).getAsJsonObject();
      JsonArray peers = peersObject.getAsJsonArray("peers");
      peersInfo = gson.fromJson(peers, PeerInfo[].class);
      knowPeers = new HashMap<>();
      for (PeerInfo peer : Arrays.asList(peersInfo)) {
        knowPeers.put(peer.getName(), peer);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Know peers not found. Loading default peer info");
      knowPeers = loadDefaultPeers();
    }
    return knowPeers;
  }

  private static HashMap<String, PeerInfo> loadDefaultPeers() {
    HashMap<String, PeerInfo> peerInfo = new HashMap<>();
    peerInfo.put("peer1", new PeerInfo("peer1", "applyVote", "localhost", "5500"));
    return peerInfo;
  }
}

