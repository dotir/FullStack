package Metodos2;

import java.util.Scanner;

public class ArrayAleatorio {
    public static int[] generarArrayAleatorio(int tamaño, int min, int max) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = numeroAleatorio(min, max);
        }
        return array;
    }

    public static int numeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del array: ");
        int tamaño = scanner.nextInt();

        System.out.print("Ingrese el número mínimo del rango: ");
        int min = scanner.nextInt();

        System.out.print("Ingrese el número máximo del rango: ");
        int max = scanner.nextInt();

        int[] arrayAleatorio = generarArrayAleatorio(tamaño, min, max);

        System.out.println("Array generado aleatoriamente:");
        for (int numero : arrayAleatorio) {
            System.out.print(numero + " ");
        }

        scanner.close();
    }
}
