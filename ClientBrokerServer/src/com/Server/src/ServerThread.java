package com.Server.src;

import com.API.src.Protocol;
import com.API.src.entidades.Request;
import com.API.src.entidades.Response;
import com.API.src.entidades.TypeRequest;
import com.API.src.entidades.TypeResponse;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

  private Socket socket;
  private ProxyServer proxyServer;
  private static int totalThreads = 0;

  private PrintWriter socketOutput;
  private BufferedReader socketInput;


  public ServerThread(Socket socket, ProxyServer proxyServer) {
    this.socket = socket;
    this.proxyServer = proxyServer;
    System.out.println("thread # " + (++totalThreads) + " on Server");
  }

  @Override
  public void run() {
    try {
      initBuffers();
      connect();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void connect() throws IOException {
    final int currThread = totalThreads;
    String inputLine, proccessedInputLine;
    Protocol protocol = new Protocol();
    proccessedInputLine = protocol.processInput(null);
    System.out.println(proccessedInputLine);
    socketOutput.println(proccessedInputLine);

    while ((inputLine = socketInput.readLine()) != null) {
      proccessedInputLine = protocol.processInput(inputLine);
      System.out.println("Current thread # " + currThread + " request: " + proccessedInputLine);

      Request request = new Gson().fromJson(proccessedInputLine, Request.class);

      if (request.getType() == TypeRequest.EXECUTE) {
        Response response = new Response();
        response.setType(TypeResponse.REQUEST_RECEIVED);
        response.setMessage("Request received");
        String responseString = new Gson().toJson(response);
        System.out.println(responseString);
        socketOutput.println(responseString);
        proxyServer.callService(
                request.getServiceName(),
                Integer.parseInt(request.getData())
        );
        break;
      }
    }
    socket.close();
    System.out.println("Discconect current thread #" + currThread);
  }

  private void initBuffers() throws IOException {
    socketOutput = new PrintWriter(socket.getOutputStream(), true);
    socketInput = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
    );
  }
}
