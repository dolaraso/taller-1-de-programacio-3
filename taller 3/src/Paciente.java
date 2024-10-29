import java.util.PriorityQueue;
import java.util.Scanner;

class Paciente implements Comparable<Paciente> {
    String nombre;
    int prioridad;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }

    @Override
    public String toString() {
        return nombre + " ha sido atendido (prioridad " + prioridad + ").";
    }
}

