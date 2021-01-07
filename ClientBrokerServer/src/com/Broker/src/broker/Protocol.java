package com.Broker.src.broker;

import com.Broker.src.broker.entidades.Response;
import com.Broker.src.broker.entidades.TypeResponse;
import com.google.gson.Gson;

public class Protocol {
  private static final int WAITING = 0;
  private static final int ATENDING = 1;
  private static final String ERROR = "error";

  public String processInput(String input) {
    String output = null;

    if (input == null) {
      Response brokerResponse = new Response();
      brokerResponse.setType(TypeResponse.CONNECTED);
      output = new Gson().toJson(brokerResponse);
    }

    if (input != null) {
      if (input.startsWith("{") && input.endsWith("}")) {
        output = input;
      } else {
        output = ERROR;
      }
    }
    return output;
  }
}
