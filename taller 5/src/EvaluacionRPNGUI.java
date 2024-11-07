import javax.swing.*;

public class EvaluacionRPNGUI {
    private JPanel panel1;
    private JButton calcularButton;
    private JTextField textField1;
    private JTextArea textArea1;

    public EvaluacionRPNGUI() {
        calcularButton.addActionListener(e -> {
            String expresion = textField1.getText();
            try {
                int resultado = evaluarRPN(expresion);
                textArea1.setText("Resultado: " + resultado);
            } catch (Exception ex) {
                textArea1.setText("Error en la evaluación de la expresión");
            }
        });
    }

    public static int evaluarRPN(String expresion) {
        PilaNumeros pila = new PilaNumeros();
        String[] tokens = expresion.split(" ");

        for (String token : tokens) {
            if (esNumero(token)) {
                pila.apilar(Integer.parseInt(token));
            } else {
                int b = pila.desapilar();
                int a = pila.desapilar();
                int resultado;

                switch (token) {
                    case "+":
                        resultado = a + b;
                        break;
                    case "-":
                        resultado = a - b;
                        break;
                    case "*":
                        resultado = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        resultado = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("Operador desconocido: " + token);
                }
                pila.apilar(resultado);
            }
        }
        return pila.desapilar();
    }

    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("EvaluacionRPNGUI");
        EvaluacionRPNGUI gui = new EvaluacionRPNGUI();
        frame.setContentPane(gui.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



