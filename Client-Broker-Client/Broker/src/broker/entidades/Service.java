package broker.entidades;

public class Service {
  private SocketAddr socketAddr;
  private String service;
  private boolean active;

  public Service(SocketAddr socketAddr, String service) {
    this.socketAddr = socketAddr;
    this.service = service;
    this.active = true;
  }

  public SocketAddr getSocketAddr() {
    return socketAddr;
  }

  public String getService() {
    return service;
  }

  public void setSocketAddr(SocketAddr socketAddr) {
    this.socketAddr = socketAddr;
  }

  public void setService(String service) {
    this.service = service;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
