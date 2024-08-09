package Metodos1;

import java.util.Scanner;

public class Complementario1 {
    

    private static Scanner scanner = new Scanner(System.in);

    public static int pedirNumero() {
        System.out.print("Por favor, introduce un número para obtener su tabla de multiplicar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next(); // Limpiar el buffer del scanner
        }
        return scanner.nextInt();
    }

    public static void imprimirTablaMultiplicar(int numero) {
        System.out.println("Tabla de multiplicar del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    public static void main(String[] args) {
        int numero = pedirNumero();
        imprimirTablaMultiplicar(numero);
        scanner.close();
    }
}
