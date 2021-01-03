package broker;

import broker.entidades.Response;
import broker.entidades.TypeResponse;
import com.google.gson.Gson;

public class Protocol {
  private static final int WAITING = 0;
  private static final int ATENDING = 1;
  private static final String ERROR = "Error";

  private int state = WAITING;

  public String processInput(String input) {
    String output = null;

    if (isNull(input)) {
      Response brokerResponse = new Response();
      brokerResponse.setType(TypeResponse.CONNECTED);
      output = new Gson().toJson(brokerResponse);
    }

    if (!isNull(input)) {
      if (input.startsWith("{") && input.endsWith("}")) {
        output = input;
      } else {
        output = ERROR;
      }
    }
    return output;
  }

  private boolean isNull(Object o) {
    return o == null;
  }
}
