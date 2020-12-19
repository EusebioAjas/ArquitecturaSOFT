package mvc.before;

import mvc.before.utils.JFreeChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.List;

public class GraficaCircular implements Observador{
  private static final DefaultPieDataset datos = new DefaultPieDataset();
  public GraficaCircular() {
    init();
  }

  private void init(){
    JFreeChart graficaCircular = JFreeChartUtils.getGraficaCircular(datos, "Votos");
    JFreeChartUtils.initFrame(graficaCircular, 710, 100, "Votos Grafica Circular");
  }

  @Override
  public void actualizar(Object dato) {
    List<Candidato> candidatos = (List<Candidato>) dato;
    candidatos.forEach(x -> datos.setValue(x.getNombre(), x.getNumVotos()));
  }
}
