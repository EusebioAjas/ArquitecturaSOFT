package com.Server.src.exceptions;

public class JsonFormatException extends Exception {
  String message = "Invalid formar, is not a json";

  @Override
  public String getMessage() {
    return message;
  }
}
