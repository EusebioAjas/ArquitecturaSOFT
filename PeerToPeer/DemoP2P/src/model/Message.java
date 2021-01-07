package model;

public class Message {
  private String sender;
  private String data;

  public Message(String theSender, String rawData) {
    this.sender = theSender;
    this.data = rawData;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
