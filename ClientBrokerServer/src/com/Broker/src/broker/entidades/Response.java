package com.Broker.src.broker.entidades;

public class Response {
  private int type;
  private String message;
  private String error;
  private String data;

  public Response() {
  }

  public Response(int type, String message, String error, String data) {
    this.type = type;
    this.message = message;
    this.error = error;
    this.data = data;
  }

  public int getType() {
    return type;
  }

  public String getMessage() {
    return message;
  }

  public String getError() {
    return error;
  }

  public String getData() {
    return data;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setError(String error) {
    this.error = error;
  }

  public void setData(String data) {
    this.data = data;
  }
}
