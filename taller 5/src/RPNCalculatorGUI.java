import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class RPNCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JTextArea resultArea;

    public RPNCalculatorGUI() {
        setTitle("Calculadora en Forma Polaca Inversa (RPN)");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel para el campo de entrada y el botón
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JLabel inputLabel = new JLabel("Ingrese su expresión en RPN:");
        inputField = new JTextField();
        JButton evaluateButton = new JButton("Evaluar");

        evaluateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String[] tokens = input.split(" ");
                try {
                    int result = evaluateRPN(tokens);
                    resultArea.setText("El resultado de la expresión es: " + result);
                } catch (Exception ex) {
                    resultArea.setText("Error al evaluar la expresión: " + ex.getMessage());
                }
            }
        });

        // Añadir el label y el campo de entrada al panel de entrada
        inputPanel.add(inputLabel, BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(evaluateButton, BorderLayout.EAST);

        // Área de resultados
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBorder(BorderFactory.createTitledBorder("Resultado"));

        // Panel de ejemplos
        JTextArea exampleArea = new JTextArea();
        exampleArea.setEditable(false);
        exampleArea.setText("Ejemplos de expresiones válidas:\n" +
                "1. 5 1 2 + 4 * + 3 -  (Resultado: 14)\n" +
                "2. 10 2 8 * + 3 -  (Resultado: 23)\n" +
                "3. 4 2 / 3 +  (Resultado: 5)\n" +
                "4. 3 4 + 2 * 7 -  (Resultado: 7)\n" +
                "5. 5 0 /  (Error: División por cero)\n");
        exampleArea.setBorder(BorderFactory.createTitledBorder("Ejemplos"));
        exampleArea.setLineWrap(true);
        exampleArea.setWrapStyleWord(true);

        // Añadir componentes a la ventana
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(new JScrollPane(exampleArea), BorderLayout.SOUTH);
    }

    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Error: División por cero.");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Operador no soportado: " + operator);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RPNCalculatorGUI calculator = new RPNCalculatorGUI();
            calculator.setVisible(true);
        });
    }
}