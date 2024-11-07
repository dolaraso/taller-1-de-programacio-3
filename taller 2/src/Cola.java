import javax.swing.*;

public class Cola {
    public Nodo frente;
    public Nodo finalCola;

    public int tamano;

    public Cola() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrarCola(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La cola está vacía.");
        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;

            while (actual != null) {
                colaStr.append(actual.dato).append(" ha sido agregado a la cola.\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    public void actualizarCola(JTextArea textArea) {
        mostrarCola(textArea);
    }

    public void encolar(String dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        tamano++;
        actualizarCola(textArea);
    }

    public String desencolar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return null;
        }
        String dato = frente.dato;
        frente = frente.siguiente;
        tamano--;

        if (frente == null) {
            finalCola = null;
        }
        textArea.append(dato + " ha sido atendido.\n");
        actualizarCola(textArea);
        return dato;
    }
}
