package Metodos3;

public class NumerosPrimos {
    
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Los primeros " + n + " números primos son:");
        int contador = 0;
        int i = 2;
        while (contador < n) {
            if (esPrimo(i)) {
                System.out.print(i + " ");
                contador++;
            }
            i++;
        }
    }

    public static boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
