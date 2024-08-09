package Metodos2;

import java.util.Scanner;

public class AdivinarNumero {
    public static int numeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 20;
        int numeroAleatorio = numeroAleatorio(min, max);
        int intento;

        System.out.println("Adivina el número entre " + min + " y " + max + ":");

        do {
            System.out.print("Introduce tu intento: ");
            intento = scanner.nextInt();

            if (intento < numeroAleatorio) {
                System.out.println("El número es mayor.");
            } else if (intento > numeroAleatorio) {
                System.out.println("El número es menor.");
            } else {
                System.out.println("¡Correcto! Has adivinado el número.");
            }
        } while (intento != numeroAleatorio);

        scanner.close();
    }
}
