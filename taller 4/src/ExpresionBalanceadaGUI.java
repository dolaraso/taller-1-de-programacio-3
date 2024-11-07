import javax.swing.*;

public class ExpresionBalanceadaGUI {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton BALANCEARButton;
    private JTextField textField1;

    public ExpresionBalanceadaGUI() {
        BALANCEARButton.addActionListener(e -> {
            String expresion = textField1.getText();
            if (esBalanceada(expresion)) {
                textArea1.setText("Balanceada");
            } else {
                textArea1.setText("No balanceada");
            }
        });
    }

    public static boolean esBalanceada(String expresion) {
        Pila pila = new Pila();
        for (char c : expresion.toCharArray()) {



            if (c == '(' || c == '{' || c == '[') {
                pila.apilar(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (pila.estaVacia()) {
                    return false;
                }
                char tope = pila.desapilar();
                if ((c == ')' && tope != '(') || (c == '}' &&
                        tope != '{') || (c == ']' && tope != '[')) {
                    return false;
                }
            }
        }
        return pila.estaVacia();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ExpresionBalanceadaGUI");
        ExpresionBalanceadaGUI gui = new
                ExpresionBalanceadaGUI();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

