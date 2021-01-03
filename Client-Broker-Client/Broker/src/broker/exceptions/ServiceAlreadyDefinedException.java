package broker.exceptions;

public class ServiceAlreadyDefinedException extends ServiceException {
  private String message = "Service is already registered";

  @Override
  public String getMessage() {
    return message;
  }
}
