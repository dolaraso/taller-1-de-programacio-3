import javax.swing.*;

public class PilaNumeros {
    private NodoNumero tope;

    public PilaNumeros() {
        tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void apilar(int dato) {
        NodoNumero nuevoNodo = new NodoNumero(dato);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
    }

    public int desapilar() {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "Error: La pila está vacía");
            return -1;
        }
        int dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }
}

