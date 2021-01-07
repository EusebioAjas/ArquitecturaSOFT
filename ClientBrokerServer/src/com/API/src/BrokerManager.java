package com.API.src;

import com.API.src.entidades.BrokerAdrr;

import java.util.HashMap;

public class BrokerManager {
  private static final String DEFAULT_BROKER = "1";

  private static BrokerManager instance;
  private static HashMap<String, BrokerAdrr> knownBrokers;

  public synchronized static BrokerManager getInstance() {
    if (instance == null) {
      instance = new BrokerManager();
    }
    return instance;
  }

  private BrokerManager() {
    initBrokerConfig();
  }

  public Connection getDefaultConnection() {
    return getConnection(DEFAULT_BROKER);
  }

  public Connection getConnection(String brokerName) {
    BrokerAdrr broker = knownBrokers.get(brokerName);

    Connection connection;
    connection = new Connection(
            broker.getIp(),
            broker.getPort()
    );

    return connection;
  }

  private void initBrokerConfig() {
    knownBrokers = BrokersReader.loadBrokers();
  }

}
