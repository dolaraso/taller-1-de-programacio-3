import java.util.PriorityQueue;
import java.util.Scanner;

public class Emergencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de pacientes
        System.out.print("Ingrese la cantidad de pacientes: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        PriorityQueue<Paciente> colaPrioridad = new PriorityQueue<>();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre y la prioridad del paciente (nombre prioridad): ");
            String entrada = scanner.nextLine();
            String[] partes = entrada.split(" ");
            String nombre = partes[0];
            int prioridad = Integer.parseInt(partes[1]);

            // Agregar el paciente a la cola de prioridad
            colaPrioridad.add(new Paciente(nombre, prioridad));
        }

        // Atender a los pacientes en orden de prioridad
        while (!colaPrioridad.isEmpty()) {
            Paciente paciente = colaPrioridad.poll();
            System.out.println(paciente);
        }

        scanner.close();
    }
}