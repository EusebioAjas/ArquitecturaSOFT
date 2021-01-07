package com.Broker.src.broker.entidades;

public class BrokerAdrr {
  private String name;
  private String ip;
  private int port;

  public BrokerAdrr(String name, String ip, int port) {
    this.name = name;
    this.ip = ip;
    this.port = port;
  }

  public String getName() {
    return name;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  public void setName(String name) {
    this.name = name;
  }


  public void setIp(String ip) {
    this.ip = ip;
  }

  public void setPort(int port) {
    this.port = port;
  }

  @Override
  public String toString() {
    String format = "%s, %s %d";
    return String.format(format, getName(), getIp(), getPort());
  }
}
