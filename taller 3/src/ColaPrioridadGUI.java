import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaPrioridadGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextField txtPrioridad;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;

    ColaPrioridad cp = new ColaPrioridad();

    public ColaPrioridadGUI() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtElemento.getText();
                String prioridadStr = txtPrioridad.getText();

                try {
                    int prioridad = Integer.parseInt(prioridadStr);
                    cp.encolarPaciente(nombre, prioridad, txtResultado);
                    txtElemento.setText("");
                    txtPrioridad.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error al encolar, valores erróneos");
                }
            }
        });

        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cp.desencolarPaciente(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaPrioridadGUI");
        frame.setContentPane(new ColaPrioridadGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
