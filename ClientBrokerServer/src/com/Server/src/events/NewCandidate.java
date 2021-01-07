package com.Server.src.events;

public class NewCandidate extends Event {
  public NewCandidate() {
    super(EventType.NEW_CANDIDATE, "New candidate added");
  }

  public NewCandidate(String info) {
    super(EventType.NEW_CANDIDATE, info);
  }
}
