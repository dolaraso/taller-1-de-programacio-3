import javax.swing.*;
class Pila {
    private Nodo tope;
    public Pila() {
        tope = null;
    }
    public boolean estaVacia() {
        return tope == null;
    }

    public void apilar(char dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public char desapilar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "Error: La pil está vacía");
            return '\0';
        }
        char dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    public char verTope() {
        if (estaVacia()) {
            return '\0';
        }
        return tope.dato;
    }
}