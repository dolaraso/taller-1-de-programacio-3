import java.util.Scanner;
import java.util.Stack;

public class BalanceoParentesis {

    public static String esBalanceada(String expresion) {
        Stack<Character> pila = new Stack<>();

        for (char charActual : expresion.toCharArray()) {
            // Si es un paréntesis abierto, lo añadimos a la pila
            if (charActual == '(' || charActual == '{' || charActual == '[') {
                pila.push(charActual);
            }
            // Si es un paréntesis cerrado
            else if (charActual == ')' || charActual == '}' || charActual == ']') {
                // Verificamos si la pila está vacía o si el paréntesis no coincide
                if (pila.isEmpty()) {
                    return "No balanceada";
                }
                char ultimoAbierto = pila.pop();
                if (!esParentesisCoincidente(ultimoAbierto, charActual)) {
                    return "No balanceada";
                }
            }
        }

        // Al final, la pila debe estar vacía si está balanceada
        return pila.isEmpty() ? "Balanceada" : "No balanceada";
    }

    private static boolean esParentesisCoincidente(char abierto, char cerrado) {
        return (abierto == '(' && cerrado == ')') ||
                (abierto == '{' && cerrado == '}') ||
                (abierto == '[' && cerrado == ']');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensaje de introducción con ejemplos
        System.out.println("Introduce una expresión matemática para verificar si está balanceada.");
        System.out.println("Ejemplos de expresiones:");
        System.out.println("1. ( { [ ] } )  -> Balanceada");
        System.out.println("2. ( { [ ] )    -> No balanceada");
        System.out.println("3. [ { ( ) } ]  -> Balanceada");
        System.out.println("4. { [ ( ] }    -> No balanceada");

        System.out.print("Tu expresión: ");
        String expresion = scanner.nextLine();  // Leer la expresión ingresada por el usuario

        // Verificar si la expresión está balanceada
        String resultado = esBalanceada(expresion);
        System.out.println("Salida: " + resultado);

        scanner.close();  // Cerrar el scanner
    }
}