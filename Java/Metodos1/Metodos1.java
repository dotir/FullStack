package Metodos1;

import java.util.Scanner;

public class Metodos1 {
    //scanner global
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //llamada al metodo obtenerNombre
        String nombre = obtenerNombre();
        //llamada al metodo obtenerEdad
        int edad = obtenerEdad();

        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
       
        //llamada al metodo imprimeNombre
        // imprimeNombre("Irving");
        //llamada al metodo imprimeNombreYEdad
        // imprimeNombreYEdad("Irving", 28);
    }

    //metodo imprimeNombre recibe un nombre y lo imprime
    public static void imprimeNombre(String nombre){
        System.out.println("Mi nombre es " + nombre);
    }

    //metodo imprimeNombreYEdad recibe un nombre y una edad e imprime ambos
    public static void imprimeNombreYEdad(String nombre, int edad){
        System.out.println("Me llamo " + nombre + " y tengo " + edad + " años");
    }

    //metodo obtener nombre usando scanner
    public static String obtenerNombre(){
        System.out.print("Por favor, introduce tu nombre: ");
        return sc.nextLine();
    }

    //metodo obtener edad usando scanner
    public static int obtenerEdad() {
        System.out.print("Por favor, introduce tu edad: ");
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido para la edad.");
            sc.next(); // Limpiar el buffer del scanner
        }
        return sc.nextInt();
    }
    

}
