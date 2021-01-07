package com.Client.src.uicliente;

import com.Client.src.model.ProxyClient;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class View {

  private final String SERVICE_NAME = "addVote";
  private JFrame frame;
  private JPanel mainPanel;
  private ProxyClient proxyClient;

  public View() {
    proxyClient = new ProxyClient();
    initComponents();
  }

  private void initComponents() {
    frame = new JFrame("UI Vote");
    frame.setSize(300, 200);
    frame.setLocationRelativeTo(null);
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    loadData();
    frame.add(mainPanel);
    frame.setVisible(true);
  }

  private void loadData() {
    ArrayList<String> candidates = new ArrayList<>();
    candidates.add("Candidate 1");
    candidates.add("Candidate 2");
    candidates.add("Candidate 3");

    Box box = Box.createVerticalBox();
    for (int i = 0; i < candidates.size(); i++) {
      final int index = i;
      JPanel panel = new JPanel();
      JButton button = new JButton("Vote for: " + candidates.get(i));
      button.addActionListener(actionEvent -> addVote(index + 1));
      box.add(button);
      panel.add(box);
      panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
      mainPanel.add(panel);
    }
  }


  public void addVote(int id) {
    String candidate = String.valueOf(id);
    System.out.println("id de candidato: " + id);
    proxyClient.sendRequest(SERVICE_NAME, candidate);
  }

}
