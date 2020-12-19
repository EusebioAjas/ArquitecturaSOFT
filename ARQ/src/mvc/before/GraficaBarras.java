package mvc.before;


import mvc.before.utils.JFreeChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class GraficaBarras implements Observador {
  private static DefaultCategoryDataset datos = new DefaultCategoryDataset();

  public GraficaBarras() {
    init();
  }

  private void init() {
    JFreeChart graficaBarra = JFreeChartUtils.getGraficaBarras(datos, "Votos", "Candidatos", "Votos");
    JFreeChartUtils.initFrame(graficaBarra, 300, 100, "Votos Grafica Barras");
  }

  @Override
  public void actualizar(Object dato) {
    List<Candidato> candidatos = (List<Candidato>) dato;
    candidatos.forEach(x -> datos.setValue(x.getNumVotos(), "Votos", x.getNombre()));
  }
}
