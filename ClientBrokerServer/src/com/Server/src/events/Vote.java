package com.Server.src.events;

public class Vote extends Event {
  public Vote() {
    super(EventType.VOTE, "New vote");
  }

  public Vote(String info) {
    super(EventType.VOTE, info);
  }

  @Override
  public String toString() {
    return getType() + getInformation();
  }
}
