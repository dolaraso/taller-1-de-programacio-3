import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class BalanceoParentesisGUI extends JFrame {

    private JTextArea inputArea;
    private JLabel resultLabel;

    public BalanceoParentesisGUI() {
        // Configuración de la ventana
        setTitle("Verificador de Paréntesis Balanceados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de texto para la entrada
        inputArea = new JTextArea();
        inputArea.setLineWrap(true);
        inputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(inputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para verificar
        JButton checkButton = new JButton("Verificar");
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expresion = inputArea.getText();
                String resultado = esBalanceada(expresion);
                resultLabel.setText("Resultado: " + resultado);
            }
        });
        add(checkButton, BorderLayout.SOUTH);

        // Etiqueta para mostrar el resultado
        resultLabel = new JLabel("Resultado: ");
        add(resultLabel, BorderLayout.NORTH);

        // Ejemplos de uso
        JLabel exampleLabel = new JLabel("<html>Ejemplos de expresiones:<br>" +
                "1. ( { [ ] } )  -> Balanceada<br>" +
                "2. ( { [ ] )    -> No balanceada<br>" +
                "3. [ { ( ) } ]  -> Balanceada<br>" +
                "4. { [ ( ] }    -> No balanceada</html>");
        add(exampleLabel, BorderLayout.WEST);
    }

    public String esBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char charActual : expresion.toCharArray()) {
            // Si es un paréntesis abierto, lo añadimos a la pila
            if (charActual == '(' || charActual == '{' || charActual == '[') {
                pila.push(charActual);
            }
            // Si es un paréntesis cerrado
            else if (charActual == ')' || charActual == '}' || charActual == ']') {
                // Verificamos si la pila está vacía o si el paréntesis no coincide
                if (pila.isEmpty()) {
                    return "No balanceada";
                }
                char ultimoAbierto = pila.pop();
                if (!esParentesisCoincidente(ultimoAbierto, charActual)) {
                    return "No balanceada";
                }
            }
        }

        // Al final, la pila debe estar vacía si está balanceada
        return pila.isEmpty() ? "Balanceada" : "No balanceada";
    }

    private boolean esParentesisCoincidente(char abierto, char cerrado) {
        return (abierto == '(' && cerrado == ')') ||
                (abierto == '{' && cerrado == '}') ||
                (abierto == '[' && cerrado == ']');
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BalanceoParentesisGUI ventana = new BalanceoParentesisGUI();
            ventana.setVisible(true);
        });
    }
}