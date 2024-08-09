package Metodos2;

import java.util.Scanner;

public class RellenarArregloAleatorio {
    public static void rellenarArray(int[] array) {
        Scanner scanner = new Scanner(System.in);
        int indice = 0;

        while (indice < array.length) {
            System.out.print("Ingrese un número para rellenar el array: ");
            int numero = scanner.nextInt();

            System.out.print("Ingrese el índice hasta el cual quiere rellenar el array con el número anterior: ");
            int nuevoIndice = scanner.nextInt();

            if (nuevoIndice > array.length) {
                System.out.println("El índice ingresado es mayor al tamaño del array. Intente nuevamente.");
                continue;
            }

            if (nuevoIndice <= indice) {
                System.out.println("El índice ingresado debe ser mayor que el último índice ingresado. Intente nuevamente.");
                continue;
            }

            for (int i = indice; i < nuevoIndice; i++) {
                array[i] = numero;
            }

            indice = nuevoIndice;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del array: ");
        int tamaño = scanner.nextInt();

        int[] array = new int[tamaño];

        rellenarArray(array);

        System.out.println("Array completo:");
        for (int numero : array) {
            System.out.print(numero + " ");
        }

        scanner.close();
    }
}
