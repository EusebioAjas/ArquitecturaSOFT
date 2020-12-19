package mvc.before;

import javax.swing.*;

public class ControladorVotos extends JFrame implements Observable {

  private JPanel panel = new JPanel();
  private ModeloVotos modeloVotos = new ModeloVotos();;

  public ControladorVotos() {
    super();
    init();
  }

  private void init() {
    setLocation(530, 420);
    add(panel);
    setVisible(true);
    pack();
    setSize(300, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  @Override
  public void agregarObservador(Observador obs) {
    modeloVotos.addObservador(obs);
  }

  @Override
  public void eliminarObservador(Observador obs) {
    modeloVotos.removeObservador(obs);
  }

  @Override
  public void notificarTodos() {
    modeloVotos.getObservadores()
            .forEach(obs -> obs.actualizar(modeloVotos.getCandidatos()));
  }

  public void agregarCandidato(Candidato candidato) {
    JButton btn = new JButton(candidato.getNombre());
    modeloVotos.addCandidato(candidato);
    btn.addActionListener(e -> {
      candidato.incrementarVoto();
      System.out.println(candidato.getNombre() + ": [" + candidato.getNumVotos() + "]");
      notificarTodos();
    });
    panel.add(btn);
  }
}
