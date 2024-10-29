import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;


public class EmergenciaGUI {
    private JPanel mainPanel;
    private JTextField nombreField;
    private JSpinner prioridadSpinner;
    private JButton agregarPacienteButton;
    private JButton atenderPacienteButton;
    private JTextArea areaDeAtencion;

    private PriorityQueue<Paciente> colaPrioridad;

    public EmergenciaGUI() {
        colaPrioridad = new PriorityQueue<>();
        createUIComponents();
    }

    private void createUIComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nombreField = new JTextField(20);
        prioridadSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        agregarPacienteButton = new JButton("Agregar Paciente");
        atenderPacienteButton = new JButton("Atender Paciente");
        areaDeAtencion = new JTextArea(10, 30);
        areaDeAtencion.setEditable(false);
        areaDeAtencion.setLineWrap(true);
        areaDeAtencion.setWrapStyleWord(true);

        // Add components to the panel with constraints
        gbc.gridx = 0; gbc.gridy = 0; mainPanel.add(new JLabel("Nombre del Paciente:"), gbc);
        gbc.gridx = 1; mainPanel.add(nombreField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; mainPanel.add(new JLabel("Prioridad (1-10):"), gbc);
        gbc.gridx = 1; mainPanel.add(prioridadSpinner, gbc);
        gbc.gridx = 0; gbc.gridy = 2; mainPanel.add(agregarPacienteButton, gbc);
        gbc.gridx = 1; mainPanel.add(atenderPacienteButton, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; mainPanel.add(new JScrollPane(areaDeAtencion), gbc);

        // Add action listeners
        agregarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                int prioridad = (int) prioridadSpinner.getValue();

                // Validate input
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Por favor, ingrese el nombre del paciente.");
                    return;
                }

                // Add patient to the priority queue
                Paciente paciente = new Paciente(nombre, prioridad);
                colaPrioridad.add(paciente);

                // Clear input fields
                nombreField.setText("");
                prioridadSpinner.setValue(1);

                // Update the attention area
                actualizarListaAtencion();
            }
        });

        atenderPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atenderPaciente();
            }
        });
    }

    private void atenderPaciente() {
        if (colaPrioridad.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "No hay pacientes en espera.");
            return;
        }

        // Attend to the patient with the highest priority
        Paciente paciente = colaPrioridad.poll();
        areaDeAtencion.append("Atendiendo: " + paciente + "\n");
    }

    private void actualizarListaAtencion() {
        areaDeAtencion.setText(""); // Clear the area
        for (Paciente paciente : colaPrioridad) {
            areaDeAtencion.append(paciente + "\n");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Emergencia");
        frame.setContentPane(new EmergenciaGUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}