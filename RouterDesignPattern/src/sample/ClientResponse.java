package sample;

import requestInterfaces.Response;

public class ClientResponse implements Response<String> {
  private String response;

  @Override
  public String getResponse() {
    return response;
  }

  @Override
  public void setResponse(String value) {
    response = value;
  }
}
