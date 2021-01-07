package broker.entidades;

public class SocketAddr {
  private String ip;
  private int port;

  public SocketAddr(String ip, int port) {
    this.ip = ip;
    this.port = port;
  }

  public String getIP() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  public void setIP(String ip) {
    this.ip = ip;
  }

  public void setPort(int port) {
    this.port = port;
  }

  @Override
  public String toString() {
    return getIP() + ", " + getPort();
  }
}
