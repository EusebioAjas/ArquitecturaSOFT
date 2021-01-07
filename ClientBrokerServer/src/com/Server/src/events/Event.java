package com.Server.src.events;

public abstract class Event {
  private int type;
  private String information;

  public Event(int type, String information) {
    this.type = type;
    this.information = information;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }
}
