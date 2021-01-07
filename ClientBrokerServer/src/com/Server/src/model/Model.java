package com.Server.src.model;

import com.Server.src.events.Event;
import com.Server.src.exceptions.ServerErrorException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Model extends Observable {

  private HashMap<Integer, ArrayList<Observer>> observers;

  public Model() {
    observers = new HashMap<>();
  }

  public HashMap<Integer, ArrayList<Observer>> getObservers() {
    return observers;
  }

  @Override
  public void register(Event e, Observer o) {
    getObserversList(e.getType()).add(o);
  }

  private ArrayList<Observer> getObserversList(int eventType) {
    if (!observers.containsKey(eventType)) {
      observers.put(eventType, new ArrayList<>());
    }
    return observers.get(eventType);
  }

  @Override
  public void unRegister(Event e, Observer o) {
    getObserversList(e.getType()).remove(o);
  }

  @Override
  public void notify(Event e) {
    int eventType = e.getType();
    ArrayList notifyObservers = observers.get(eventType);
    Observer observer;
    for (Iterator it = notifyObservers.iterator(); it.hasNext(); ) {
      observer = (Observer) it.next();
      observer.update(e);
    }
  }

  public void callFun(Class cClass, Class cTarget, String name, Object...params) throws ServerErrorException {
    Method method = null;
    try{
      method = cClass.getMethod(name, cTarget);
    } catch (NoSuchMethodException e) {
      throw new ServerErrorException();
    }

    try{
      method.invoke(this, params);
    } catch (IllegalAccessException | InvocationTargetException e) {
      throw new ServerErrorException();
    }
  }
}
