package Metodos3;

import java.util.Scanner;

public class ManipularOraciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String oracion;
        int opcion;
        // menu de opciones
        do {
            System.out.println("1. Ingresar oracion");
            System.out.println("2. Cantidad de caracteres");
            System.out.println("3. Cantidad de palabras");
            System.out.println("4. Mostrar palabras ordenadas alfabeticamente");
            System.out.println("5. Ingresar un numero y mostrar la palabra en esa posicion");
            System.out.println("6. Buscar palabra dentro de la oracion");
            System.out.println("7. Agregar contenido a la oracion");
            System.out.println("8. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una oracion: ");
                    oracion = scanner.nextLine();
                    System.out.println("Oracion ingresada: " + oracion);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Hasta luego");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
        scanner.close();
    }
}
