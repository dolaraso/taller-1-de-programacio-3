import javax.swing.*;
import java.util.PriorityQueue;
import java.util.Comparator;

class Paciente {
    String nombre;
    int prioridad;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
}

public class ColaPrioridad {
    private PriorityQueue<Paciente> cola;

    public ColaPrioridad() {
        cola = new PriorityQueue<>(
                new Comparator<Paciente>() {
                    @Override
                    public int compare(Paciente p1, Paciente p2) {
                        return Integer.compare(p1.prioridad, p2.prioridad);
                    }
                }
        );
    }

    public void encolarPaciente(String nombre, int prioridad, JTextArea textArea) {
        cola.add(new Paciente(nombre, prioridad));
        textArea.append(nombre + " ha sido agregado a la cola con prioridad " + prioridad + ".\n");
    }

    public void desencolarPaciente(JTextArea textArea) {
        if (!cola.isEmpty()) {
            Paciente pacienteAtendido = cola.poll();
            textArea.append(pacienteAtendido.nombre + " ha sido atendido (prioridad " + pacienteAtendido.prioridad + ").\n");
        } else {
            JOptionPane.showMessageDialog(null, "No hay pacientes en la cola.", "Atención", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }
}
