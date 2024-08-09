package Metodos1;

import java.util.Scanner;

public class Complementario2 {
    
    private static Scanner scanner = new Scanner(System.in);

    public static int[] pedirNumeros() {
        int[] numeros = new int[3];
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Por favor, introduce el número " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // Limpiar el buffer del scanner
            }
            numeros[i] = scanner.nextInt();
        }
        return numeros;
    }

    public static void imprimirTablasMultiplicar(int[] numeros) {
        for (int numero : numeros) {
            System.out.println("Tabla de multiplicar del " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
            System.out.println(); // Línea en blanco para separar las tablas
        }
    }

    public static void main(String[] args) {
        int[] numeros = pedirNumeros();
        imprimirTablasMultiplicar(numeros);
        scanner.close();
    }
}
