package requestInterfaces;

public interface Request<T> {
  T getRequest();

  void setRequest(T value);
}
