package com.Client.src.model;

import com.API.src.BrokerManager;
import com.API.src.Connection;
import com.API.src.exceptions.ServiceNotAvailableException;
import com.API.src.exceptions.ServiceNotFoundException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.swing.*;
import javax.xml.ws.Response;
import java.io.IOException;


public class ProxyClient {
  private Connection connection;

  public void sendRequest(String serviceName, String data) {
    try {
      connection = BrokerManager.getInstance().getDefaultConnection();
      System.out.println(connection);
      connection.open();
      if (connection.findService(serviceName)) {
        connection.executeService(serviceName, data);
        System.out.println("Encontrado");
      } else {
        throw new ServiceNotFoundException();
      }
      connection.close();
    } catch (IOException | ServiceNotFoundException e) {
      final JPanel panel = new JPanel();
      System.out.println("Error no se encotró");
      JOptionPane.showMessageDialog(panel, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (ServiceNotAvailableException e) {
      e.printStackTrace();
    }
  }


  public String packData(int type, String serviceName, String data) {
    String entity;
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("type", type);
    jsonObject.addProperty("serviceName", serviceName);
    jsonObject.addProperty("data", data);
    entity = jsonObject.toString();

    return entity;
  }

  public Response unpackData(String brokerResponse) {
    Response response;
    response = new Gson().fromJson(brokerResponse, Response.class);
    return response;
  }
}
