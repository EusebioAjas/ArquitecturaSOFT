package com.Server.src;

import com.API.src.BrokerManager;
import com.API.src.Connection;
import com.API.src.entidades.Response;
import com.API.src.exceptions.ServiceAlreadyDefinedException;
import com.Server.src.exceptions.ServerErrorException;
import com.Server.src.model.ServerResponses;
import com.Server.src.model.Votations;

import java.io.IOException;

public class ProxyServer {
  private Connection connection;

  public void callService(String serviceName, Object... params) {
    try {
      Votations.getInstance().callFun(Votations.class, int.class, serviceName, params);
    } catch (ServerErrorException e) {
      sendResponse(ServerResponses.FAILURE);
    }

    sendResponse(ServerResponses.SUCCESS);
  }

  public void sendResponse(int responseType) {
    Response response = new Response();
    response.setType(responseType);
  }

  public void registerServiceToBroker() {
    try {
      connection = BrokerManager.getInstance().getDefaultConnection();
      connection.open();
      connection.resgisterService(Server.PORT, "addVote");
      connection.close();
    } catch (ServiceAlreadyDefinedException | IOException e) {
      e.printStackTrace();
    }
  }

  public void changeServiceState() {
    try {
      connection = BrokerManager.getInstance().getDefaultConnection();
      connection.open();
      connection.changeServiceState("addVote", true);
      connection.close();
    } catch (ServiceAlreadyDefinedException | IOException e) {
      e.printStackTrace();
    }
  }
}
