package Excepciones;

import java.util.Scanner;

public class divisionSegura {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrse un numero: ");
        int numero1 = scanner.nextInt();
        System.out.println("Ingrse otro numero: ");
        int numero2 = scanner.nextInt();

        obtenerNumerador(numero1, numero2);
        scanner.close();
    }

    public static void obtenerNumerador(int numero1, int numero2)  {
        try {
            int resultado = numero1 / numero2;
            System.out.println("El resultado de la division es: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir por cero");
        }
    }
}
