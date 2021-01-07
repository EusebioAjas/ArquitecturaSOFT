package com.Server.src.model;

import com.Server.src.events.Event;

public abstract class Observable {
  abstract void register(Event e, Observer o);

  abstract void unRegister(Event e, Observer o);

  abstract void notify(Event e);
}
