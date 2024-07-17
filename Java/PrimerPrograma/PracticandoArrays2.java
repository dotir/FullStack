import java.util.Scanner;
import java.util.Arrays;

public class PracticandoArrays2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        //1. Ordenar de manera descendiente un array de 10 elementos
        int[] numeros1 = new int[10];
        //valores del 1 al 100
        for (int i = 0; i < numeros1.length; i++) {
            numeros1[i] = (int) (Math.random() * 100) + 1;
        }
        //mostrar el array
        for (int i = 0; i < numeros1.length; i++) {
            System.out.println(numeros1[i]);
        }
        System.out.println("------------------------------------------------------");
        //ordenar de forma descendiente con método Arrays.sort()
        java.util.Arrays.sort(numeros1);
        //invertir el array
        for (int i = 0; i < numeros1.length / 2; i++) {
            int aux = numeros1[i];
            numeros1[i] = numeros1[numeros1.length - 1 - i];
            numeros1[numeros1.length - 1 - i] = aux;
        }
        //mostrar el array
        for (int i = 0; i < numeros1.length; i++) {
            System.out.println(numeros1[i]);
        }

        //2. Realizar busqueda binaria mediante el metodo Arrays.binarySearch()
        int[] numeros2 = new int[10];
        //valores del 1 al 100
        for (int i = 0; i < numeros2.length; i++) {
            numeros2[i] = (int) (Math.random() * 100) + 1;
        }
        //mostrar el array
        for (int i = 0; i < numeros2.length; i++) {
            System.out.println(numeros2[i]);
        }
        System.out.println("------------------------------------------------------");
        //ordenar de forma ascendente con método Arrays.sort()
        Arrays.sort(numeros2);
        //mostrar el array
        for (int i = 0; i < numeros2.length; i++) {
            System.out.println(numeros2[i]);
        }
        //buscar un número
        System.out.println("INgrese un número a buscar");
        int numerobuscar = sc.nextInt();
        int posicion = Arrays.binarySearch(numeros2, numerobuscar);
        if (posicion >= 0) {
            System.out.println("El número " + numerobuscar + " se encuentra en la posición " + (posicion+1));
        } else {
            System.out.println("El número " + numerobuscar + " no se encuentra en el array");
        }
        sc.close();

        //3. Comparar dos arrays con Arrays.equals()
        int[] numeros31 = new int[10];
        int[] numeros32 = new int[10];
        //valores del 1 al 100
        for (int i = 0; i < numeros31.length; i++) {
            numeros31[i] = (int) (Math.random() * 100) + 1;
            numeros32[i] = (int) (Math.random() * 100) + 1;
        }
        //mostrar el array
        System.out.println("Array 1");
        for (int i = 0; i < numeros31.length; i++) {
            System.out.println(numeros31[i]);
        }
        System.out.println("Array 2");
        for (int i = 0; i < numeros32.length; i++) {
            System.out.println(numeros32[i]);
        }
        System.out.println("------------------------------------------------------");
        //comparar arrays
        if (Arrays.equals(numeros31, numeros32)) {
            System.out.println("Los arrays son iguales");
        } else {
            System.out.println("Los arrays son diferentes");
        }

        //4. Copiar parte de un array con Arrays.copyOfRange()
        int[] numeros4 = new int[10];
        //valores del 1 al 100
        for (int i = 0; i < numeros4.length; i++) {
            numeros4[i] = (int) (Math.random() * 100) + 1;
        }
        //ordenar
        Arrays.sort(numeros4);
        //mostrar el array
        for (int i = 0; i < numeros4.length; i++) {
            System.out.println(numeros4[i]);
        }
        System.out.println("------------------------------------------------------");
        //copiar parte del array
        System.out.println("ingrese el rango de elementos a copiar");

        System.out.println("Ingrese el indice de inicio");
        int inicio = sc.nextInt();
        System.out.println("Ingrese el indice final:");
        int final1 = sc.nextInt();
        int[] copia = Arrays.copyOfRange(numeros4, inicio, final1);
        //mostrar la copia
        System.out.println("Array copia");
        for (int i = 0; i < copia.length; i++) {
            System.out.println(copia[i]);
        }
        sc.close();

        //5. Rellenar un array con Arrays.fill()
        int[] numeros5 = new int[10];
        //rellenar el array con el valor 5
        Arrays.fill(numeros5, 0,numeros5.length,5);
        //mostrar el array
        for (int i = 0; i < numeros5.length; i++) {
            System.out.println(numeros5[i]);
        }

        //Ejercicios Complemetarios
        // 1. Rellenar un array con valores personalizados
        System.out.println("Ingrese el tamaño del array");
        int tam = sc.nextInt();
        int[] numeros1comp = new int[tam];
        System.out.print("Ingrese un valor para rellenar el array: ");
        int valor = sc.nextInt();
        System.out.println("Ingrese el indice de inicio");
        int iniciocomp = sc.nextInt();
        System.out.println("Ingrese el indice final:");
        int final1comp = sc.nextInt();
        Arrays.fill(numeros1comp, iniciocomp, final1comp, valor);
        //mostrar el array
        System.out.println("Array rellenado");
        for (int i = 0; i < numeros1comp.length; i++) {
            System.out.println(numeros1comp[i]);
        }
        sc.close();
    }

}
