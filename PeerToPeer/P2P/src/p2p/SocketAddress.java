package p2p;

public class SocketAddress {
  private String ip;
  private String port;
  private String serviceName;

  public SocketAddress(String ip, String port, String serviceName) {
    this.ip = ip;
    this.port = port;
    this.serviceName = serviceName;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  @Override
  public String toString() {
    return getIp() + ", " + getPort() + ", " + getServiceName();
  }
}
