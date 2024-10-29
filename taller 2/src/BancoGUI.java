import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class BancoGUI extends JFrame {
    private Queue<String> cola;
    private JTextArea textArea;
    private JTextField clienteField;
    private JButton agregarButton;
    private JButton atenderButton;
    private int numClientes;

    public BancoGUI() {
        cola = new LinkedList<>();
        numClientes = 0;

        setTitle("Banco");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Ingrese el nombre del cliente:");
        add(label);

        clienteField = new JTextField(20);
        add(clienteField);

        agregarButton = new JButton("Agregar Cliente");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });
        add(agregarButton);

        atenderButton = new JButton("Atender Cliente");
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atenderCliente();
            }
        });
        add(atenderButton);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        add(new JScrollPane(textArea));

        setVisible(true);
    }

    private void agregarCliente() {
        String nombre = clienteField.getText().trim();
        if (!nombre.isEmpty()) {
            cola.add(nombre);
            numClientes++;
            clienteField.setText("");
            textArea.append(nombre + " ha sido agregado a la cola.\n");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre.");
        }
    }

    private void atenderCliente() {
        if (!cola.isEmpty()) {
            String clienteAtendido = cola.poll();
            textArea.append(clienteAtendido + " ha sido atendido.\n");
        } else {
            JOptionPane.showMessageDialog(this, "No hay clientes en la cola.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BancoGUI());
    }
}