package com.API.src.entidades;

public class Service {
  private String ip;
  private int port;
  private String service;
  private boolean status;

  public Service(String ip, int port, String service, boolean status) {
    this.ip = ip;
    this.port = port;
    this.service = service;
    this.status = status;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }


  public String getService() {
    return service;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public void setService(String service) {
    this.service = service;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
