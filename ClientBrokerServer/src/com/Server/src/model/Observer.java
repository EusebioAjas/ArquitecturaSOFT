package com.Server.src.model;

import com.Server.src.events.Event;

@FunctionalInterface
public interface Observer {
  void update(Event event);
}
