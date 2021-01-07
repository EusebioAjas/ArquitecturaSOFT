package mvc.before;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    modeloVotos.addCandidato(candidato);
    JButton btn = new JButton(candidato.getNombre());
    btn.addActionListener(e -> notificarVoto(candidato));
  }

  private void notificarVoto(Candidato candidato){
    candidato.incrementarVoto();
    notificarTodos();
  }
}
