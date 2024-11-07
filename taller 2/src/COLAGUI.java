import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COLAGUI {
    private JPanel pGeneral;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton encolarButton;
    private JButton desencolarButton;

    public Cola c = new Cola();

    public COLAGUI() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valor = textField1.getText();
                if (!valor.isEmpty()) {
                    c.encolar(valor, textArea1);
                    textField1.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un nombre.");
                }
            }
        });

        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String atendido = c.desencolar(textArea1);
                if (atendido != null) {
                    JOptionPane.showMessageDialog(null, atendido + " ha sido atendido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simulador de Cola en el Banco");
        frame.setContentPane(new COLAGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}