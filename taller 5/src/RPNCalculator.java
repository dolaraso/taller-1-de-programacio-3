import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {

    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isInteger(token)) {
                // Si el token es un número, lo empujamos a la pila
                stack.push(Integer.parseInt(token));
            } else {
                // Si el token es un operador, sacamos dos números de la pila
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                // Colocamos el resultado de la operación de nuevo en la pila
                stack.push(result);
            }
        }

        // El resultado final será el único elemento en la pila
        return stack.pop();
    }

    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Error: División por cero.");
                }
                return a / b;
            default:
                throw new UnsupportedOperationException("Operador no soportado: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("  Bienvenido al Evaluador RPN        ");
        System.out.println("=======================================");
        System.out.println("Ingrese una expresión en Forma Polaca Inversa (RPN):");
        System.out.println("Ejemplos de expresiones válidas:");
        System.out.println("1. 5 1 2 + 4 * + 3 -  (Resultado: 14)");
        System.out.println("2. 10 2 8 * + 3 -  (Resultado: 23)");
        System.out.println("3. 4 2 / 3 +  (Resultado: 5)");
        System.out.println("4. 3 4 + 2 * 7 -  (Resultado: 7)");
        System.out.println("5. 5 0 /  (Error: División por cero)");
        System.out.println("=======================================");
        System.out.print("Ingrese su expresión: ");

        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        try {
            int result = evaluateRPN(tokens);
            System.out.println("=======================================");
            System.out.println("El resultado de la expresión es: " + result);
            System.out.println("=======================================");
        } catch (Exception e) {
            System.out.println("Error al evaluar la expresión: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}