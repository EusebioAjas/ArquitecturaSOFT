package broker.exceptions;

public class ServiceNotFoundException extends ServiceException {
  private String message = "Service not found. Couldn't get service requested";

  @Override
  public String getMessage() {
    return message;
  }
}
