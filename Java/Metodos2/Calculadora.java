package Metodos2;

import java.util.Scanner;

public class Calculadora {
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("Calculadora");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            if (opcion == 5) {
                salir = true;
                System.out.println("Saliendo de la calculadora...");
                continue;
            }

            double num1 = solicitarNumero("Ingrese el primer número: ");
            double num2 = solicitarNumero("Ingrese el segundo número: ");

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Error: División por cero no permitida.");
                    } else {
                        System.out.println("Resultado: " + (num1 / num2));
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static double solicitarNumero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // Limpiar el buffer del scanner
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        menu();
        scanner.close();
    }
}
