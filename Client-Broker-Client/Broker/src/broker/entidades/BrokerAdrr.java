package broker.entidades;

public class BrokerAdrr {
  private String name;
  private SocketAddr socketAddr;

  public BrokerAdrr(String name, SocketAddr socketAddr) {
    this.name = name;
    this.socketAddr = socketAddr;
  }

  public String getName() {
    return name;
  }

  public SocketAddr getSocketAddr() {
    return socketAddr;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSocketAddr(SocketAddr socketAddr) {
    this.socketAddr = socketAddr;
  }

  @Override
  public String toString() {
    String format = "%s, %s";
    return String.format(format, getName(), getSocketAddr());
  }
}
