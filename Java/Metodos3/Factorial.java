package Metodos3;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("El factorial de " + n + " es: " + factorial(n));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
