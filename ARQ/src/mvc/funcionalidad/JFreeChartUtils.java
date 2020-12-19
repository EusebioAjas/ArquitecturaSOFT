package mvc.funcionalidad;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;

public class JFreeChartUtils {

  public static JFreeChart getGraficaBarras(CategoryDataset datos, String title, String categorylabel, String valueLabel) {
    return ChartFactory.createBarChart3D(
            title,
            categorylabel,
            valueLabel,
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            true
    );
  }

  public static JFreeChart getGraficaCircular(DefaultPieDataset datos, String title){
    return ChartFactory.createPieChart3D(
            title,
            datos,
            true,
            true,
            true
    );
  }

  public static void initFrame(JFreeChart grafica, int xLocation, int yLocation, String title) {
    ChartFrame frame = new ChartFrame(title, grafica);
    frame.setSize(400, 300);
    frame.setLocation(xLocation, yLocation);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
