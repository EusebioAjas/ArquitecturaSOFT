package requestInterfaces;

public interface Response<T> {
  T getResponse();

  void setResponse(T value);
}
