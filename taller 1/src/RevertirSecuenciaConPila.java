import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class RevertirSecuenciaConPila extends JFrame {
    private JTextField entrada; // Campo de texto para la entrada del usuario
    private JTextArea salida; // Área de texto para mostrar la salida

    public RevertirSecuenciaConPila() {
        // Configuración de la ventana
        setTitle("Revertir Secuencia con Pila");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Inicialización de componentes
        entrada = new JTextField(20);
        JButton boton = new JButton("Revertir");
        salida = new JTextArea(10, 30);
        salida.setEditable(false); // Hacer que el área de salida no sea editable

        // Acción del botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = entrada.getText(); // Obtener el texto ingresado
                String resultado = revertirSecuencia(input); // Llamar al método para revertir
                salida.setText(resultado); // Mostrar el resultado en el área de salida
            }
        });

        // Crear un panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1)); // 3 filas, 1 columna

        // Agregar componentes al panel
        panel.add(new JLabel("Ingrese la secuencia de números:"));
        panel.add(new JLabel("Ejemplo: 4 5 6")); // Ejemplo de entrada
        panel.add(entrada); // Campo de entrada

        // Agregar el panel y el botón a la ventana
        add(panel);
        add(boton);
        add(new JScrollPane(salida)); // Agregar un JScrollPane para el área de salida

        setVisible(true); // Hacer visible la ventana
    }

    // Método para revertir la secuencia
    private String revertirSecuencia(String input) {
        Stack<Integer> pila = new Stack<>(); // Crear una pila
        String[] numeros = input.split(" "); // Dividir la entrada en números

        // Poner los números en la pila
        for (String numero : numeros) {
            try {
                pila.push(Integer.parseInt(numero)); // Convertir a entero y agregar a la pila
            } catch (NumberFormatException ex) {
                return "Por favor, ingrese solo números enteros."; // Manejo de errores
            }
        }

        // Sacar los números de la pila en orden inverso
        StringBuilder resultado = new StringBuilder();
        while (!pila.isEmpty()) {
            resultado.append(pila.pop()).append(" "); // Agregar a la salida
        }

        return resultado.toString().trim(); // Devolver la cadena resultante
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RevertirSecuenciaConPila());
    }
}