package com.Server.src.exceptions;

public class ServerErrorException extends Exception {
  private String message = "An error has occurred on ther server.";

  @Override
  public String getMessage() {
    return message;
  }
}
