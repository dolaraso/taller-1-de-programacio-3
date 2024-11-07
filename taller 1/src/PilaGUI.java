import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilaGUI {
    private JPanel pGeneral;
    private JTextField inputField;
    private JTextArea textArea1;
    private JButton revertirButton;

    private Pila pila = new Pila();

    public PilaGUI() {
        revertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String[] numerosStr = input.split(" ");


                for (String numStr : numerosStr) {
                    try {
                        int valor = Integer.parseInt(numStr);
                        pila.apilar(valor, textArea1);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Introduce solo números enteros válidos.");
                        return;
                    }
                }


                StringBuilder resultado = new StringBuilder();
                while (!pila.estaVacia()) {
                    resultado.append(pila.desapilar(textArea1)).append(" ");
                }

                // Mostrar el resultado en el JTextArea
                textArea1.setText(resultado.toString().trim());
                inputField.setText ("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Revertir Secuencia con Pilas");
        frame.setContentPane(new PilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}