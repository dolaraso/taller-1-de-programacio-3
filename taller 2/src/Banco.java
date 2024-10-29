import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de clientes
        System.out.print("Ingrese la cantidad de clientes: ");
        int numClientes = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear una cola para los clientes
        Queue<String> cola = new LinkedList<>();

        // Leer los nombres de los clientes y agregarlos a la cola
        for (int i = 0; i < numClientes; i++) {
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();
            cola.add(nombre);
        }

        // Procesar la cola y atender a los clientes
        while (!cola.isEmpty()) {
            String clienteAtendido = cola.poll(); // Atender al cliente en la frente de la cola
            System.out.println(clienteAtendido + " ha sido atendido.");
        }

        scanner.close();
    }
}