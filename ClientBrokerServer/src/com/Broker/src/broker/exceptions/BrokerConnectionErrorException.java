package com.Broker.src.broker.exceptions;

public class BrokerConnectionErrorException extends BrokerException {
  private String message = "Couldn't connecte to BrokerAdrr";

  @Override
  public String getMessage() {
    return message;
  }
}
