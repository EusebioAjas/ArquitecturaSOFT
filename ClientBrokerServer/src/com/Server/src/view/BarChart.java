package com.Server.src.view;

import com.Server.src.events.Event;
import com.Server.src.model.Candidate;
import com.Server.src.model.Observer;
import com.Server.src.model.Votations;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

public class BarChart implements Observer {
  private ChartFrame frame;
  private JFreeChart chart;
  private DefaultCategoryDataset data;

  public BarChart() {
    init();
  }

  private void init() {
    data = new DefaultCategoryDataset();
    loadData();
    chart = ChartFactory.createBarChart3D(
            "Votaciones",
            "Candidato",
            "Votos",
            data,
            PlotOrientation.VERTICAL, true, true, false
    );
    chart.getTitle().setPaint(Color.BLACK);
    CategoryPlot p = chart.getCategoryPlot();
    p.setRangeGridlinePaint(Color.red);

    frame = new ChartFrame("BarChart", chart);
    frame.pack();
    frame.setVisible(true);

  }

  private void loadData() {
    for (Candidate c : Votations.getInstance().getCandidates()) {
      data.setValue(c.getVotes(), "", c.getName());
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
