public class Nodo {
    public String dato; // Cambiado de int a String
    public int prioridad;
    public Nodo siguiente;

    public Nodo(String dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}
