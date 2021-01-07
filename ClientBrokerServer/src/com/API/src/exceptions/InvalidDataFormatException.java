package com.API.src.exceptions;

public class InvalidDataFormatException extends BrokerException {
  private String message = "Data format invalid fro request";

  @Override
  public String getMessage() {
    return message;
  }
}
