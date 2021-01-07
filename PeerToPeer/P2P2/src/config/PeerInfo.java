package config;

public class PeerInfo {
  private String name;
  private String serviceName;
  private String ip;
  private String port;

  public PeerInfo(String name, String serviceName, String ip, String port) {
    this.name = name;
    this.serviceName = serviceName;
    this.ip = ip;
    this.port = port;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
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
}
