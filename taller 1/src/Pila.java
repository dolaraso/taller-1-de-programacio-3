import javax.swing.*;

public class Pila {
    private Nodo cima;
    private int tamano;


    public Pila() {
        cima = null;
        tamano = 0;
    }


    public void apilar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
        tamano++;
        actualizarTextArea(textArea);
    }


    public int desapilar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La pila está vacía.");
            return -1;
        }
        int dato = cima.dato;
        cima = cima.siguiente;
        tamano--;
        actualizarTextArea(textArea);
        return dato;
    }


    public boolean estaVacia() {
        return cima == null;
    }


    public void mostrarPila(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La pila está vacía.");
        } else {
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while (actual != null) {
                pilaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(pilaStr.toString());
        }
    }


    private void actualizarTextArea(JTextArea textArea) {
        mostrarPila(textArea);
    }
}

