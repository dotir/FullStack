package Metodos2;

import java.util.Scanner;

public class Calificacion {
    public static String obtenerNota(int puntuacion) {
        return switch (puntuacion / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int puntuacion = -1;

        do {
            System.out.print("Ingrese un número entre 0 y 100: ");
            if (scanner.hasNextInt()) {
                puntuacion = scanner.nextInt();
                if (puntuacion < 0 || puntuacion > 100) {
                    System.out.println("Número fuera de rango. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
                scanner.next(); // Limpiar el buffer del scanner
            }
        } while (puntuacion < 0 || puntuacion > 100);

        String calificacion = obtenerNota(puntuacion);
        System.out.println("La calificación obtenida es: " + calificacion);

        scanner.close();
    }
}
