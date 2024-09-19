package ColeccionesArrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class sopadenumeros {
    
    public static void main(String[] args) {
        ArrayList<Integer> numeros = leerValores();
        int suma = calcularSuma(numeros);
        double promedio = calcularPromedio(numeros);
        mostrarResultados(numeros, suma, promedio);
    }

    // Método para leer valores desde el teclado y almacenarlos en un ArrayList
    public static ArrayList<Integer> leerValores() {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.println("Introduce números enteros (introduce -99 para finalizar):");
        do {
            numero = scanner.nextInt();
            if (numero != -99) {
                numeros.add(numero);
            }
        } while (numero != -99);

        scanner.close();

        return numeros;
    }

    // Método para calcular la suma de los valores en el ArrayList
    public static int calcularSuma(ArrayList<Integer> numeros) {
        int suma = 0;
        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            suma += iterator.next();
        }
        return suma;
    }

    // Método para calcular el promedio de los valores en el ArrayList
    public static double calcularPromedio(ArrayList<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0;
        }
        return (double) calcularSuma(numeros) / numeros.size();
    }

    // Método para mostrar los resultados
    public static void mostrarResultados(ArrayList<Integer> numeros, int suma, double promedio) {
        System.out.println("Número total de valores ingresados: " + numeros.size());
        System.out.println("Suma de los valores: " + suma);
        System.out.println("Media de los valores: " + promedio);

        int mayoresQueMedia = 0;
        for (int numero : numeros) {
            if (numero > promedio) {
                mayoresQueMedia++;
            }
        }
        System.out.println("Número de valores mayores que la media: " + mayoresQueMedia);
    }

}
