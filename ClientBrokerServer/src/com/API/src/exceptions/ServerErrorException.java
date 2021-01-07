package com.API.src.exceptions;

public class ServerErrorException extends Exception {
  private String message = "An error has occurred on the server";

  @Override
  public String getMessage() {
    return message;
  }
}
