package com.Server.src.view;

import com.Server.src.events.Event;
import com.Server.src.model.Candidate;
import com.Server.src.model.Observer;
import com.Server.src.model.Votations;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart implements Observer {

  private ChartFrame frame;
  private JFreeChart chart;
  private DefaultPieDataset data;

  public PieChart() {
    init();
  }

  private void init() {
    data = new DefaultPieDataset();
    loadData();

    chart = ChartFactory.createPieChart(
            "Votaciones",
            data,
            true,
            true,
            false
    );
    frame = new ChartFrame("PieChart", chart);
    frame.pack();
    frame.setVisible(true);
  }

  public void loadData() {
    for (Candidate c : Votations.getInstance().getCandidates()) {
      data.setValue(c.getName(), c.getVotes());
    }
  }

  public void display() {
    data.clear();
    loadData();
    frame.repaint();
  }

  @Override
  public void update(Event event) {
    display();
  }
}
