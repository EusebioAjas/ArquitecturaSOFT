package broker.exceptions;

public class ServiceNotAvailableException extends ServiceException {
  private String message = "Service requested is not available";

  @Override
  public String getMessage() {
    return message;
  }
}
