package config;

import java.util.HashMap;

public class PeerManager {
  private static final String DEFAULT_PEER = "peer1";
  private static HashMap<String, PeerInfo> knownPeers;
  private static PeerManager peerManager;

  public synchronized static PeerManager getInstance() {
    if (peerManager == null) {
      peerManager = new PeerManager();
    }
    return peerManager;
  }

  private PeerManager() {
    initPeerconfig();
  }

  private void initPeerconfig() {
    knownPeers = PeersLoader.loadPeersInfo();
  }

  public PeerInfo getDafaultPeer() {
    return getPeer(DEFAULT_PEER);
  }

  private PeerInfo getPeer(String peerName) {
    PeerInfo peerInfo = knownPeers.get(peerName);
    return peerInfo;
  }
}
