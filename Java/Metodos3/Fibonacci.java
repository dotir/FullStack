package Metodos3;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n,posicion;
        System.out.print("Ingrese el número de elementos de la serie de Fibonacci: ");
        n = scanner.nextInt();
        //que numero es en tal posicion
        System.out.println("El numero a buscar en la serie de Fibonacci:");
        posicion = scanner.nextInt();

        System.out.print("Serie de Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println("--------------------");
        for (int i = 0; i < n; i++) {
            if(i==posicion){
                System.out.println("En la poscicion "+posicion+" se encuentra el numero "+fibonacci(i));
            }
        }

        scanner.close();

    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
