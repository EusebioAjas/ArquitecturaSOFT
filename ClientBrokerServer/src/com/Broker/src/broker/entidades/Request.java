package com.Broker.src.broker.entidades;

public class Request {
  private int type;
  private String serviceName;
  private String data;

  public Request() {

  }

  public Request(int type, String serviceName, String data) {
    this.type = type;
    this.serviceName = serviceName;
    this.data = data;
  }

  public int getType() {
    return type;
  }

  public String getServiceName() {
    return serviceName;
  }

  public String getData() {
    return data;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  public void setData(String data) {
    this.data = data;
  }
}
