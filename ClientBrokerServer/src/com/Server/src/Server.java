package com.Server.src;

import com.Server.src.events.Event;
import com.Server.src.events.NewCandidate;
import com.Server.src.events.Vote;
import com.Server.src.model.Model;
import com.Server.src.model.Votations;
import com.Server.src.view.BarChart;
import com.Server.src.view.PieChart;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
  public static final int PORT = 2222;
  private ProxyServer proxyServer = new ProxyServer();
  private ServerSocket socket;

  public void initSocket() throws IOException {
    socket = new ServerSocket(PORT);
  }

  public void startAccceptingPetitions() {
    boolean listening = true;
    try {
      System.out.println("Listening on port " + PORT);
      while (listening) {
        ServerThread serverThread = new ServerThread(socket.accept(), proxyServer);
        new Thread(serverThread).start();
      }
    } catch (IOException e) {
      System.err.println("Could not listen on port " + PORT);
      System.exit(-1);
    }
  }

  public void registerServiceIntoBroker() {
    proxyServer.registerServiceToBroker();
  }

  public void changeServicestate() {
    proxyServer.changeServiceState();
  }

  public static void main(String[] args) throws IOException {
    Event voteEvent = new Vote("New vote");
    Event newCadidate = new NewCandidate("New candidate");

    Model votations = Votations.getInstance();

    PieChart pieChart = new PieChart();
    BarChart barChart = new BarChart();

    votations.register(voteEvent, pieChart);
    votations.register(voteEvent, barChart);

    votations.register(newCadidate, pieChart);
    votations.register(newCadidate, barChart);


    Server server = new Server();
    try {
      server.initSocket();
      server.registerServiceIntoBroker();
      server.changeServicestate();
      server.startAccceptingPetitions();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
