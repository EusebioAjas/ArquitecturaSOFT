package com.Broker.src.broker.entidades;

public class Service {
  private String ip;
  private int port;
  private String service;
  private boolean active;

  public Service(String ip, int port, String service) {
    this.ip = ip;
    this.port = port;
    this.service = service;
    this.active = true;
  }


  public String getService() {
    return service;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  public void setService(String service) {
    this.service = service;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
