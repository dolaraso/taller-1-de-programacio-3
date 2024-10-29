import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

class Paciente implements Comparable<Paciente> {

    private String nombre;

    private int prioridad;


    public Paciente(String nombre, int prioridad) {

        this.nombre = nombre;

        this.prioridad = prioridad;

    }


    public String getNombre() {

        return nombre;

    }


    public int getPrioridad() {

        return prioridad;

    }


    @Override

    public int compareTo(Paciente otro) {

        return Integer.compare(otro.prioridad, this.prioridad); // Higher priority first

    }


    @Override

    public String toString() {

        return "Paciente: " + nombre + ", Prioridad: " + prioridad;

    }

}