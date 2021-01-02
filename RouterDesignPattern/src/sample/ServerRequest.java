package sample;

import requestInterfaces.Request;

public class ServerRequest implements Request<String> {
  private String request;

  @Override
  public String getRequest() {
    return request;
  }

  @Override
  public void setRequest(String value) {
    this.request = value;
  }
}
