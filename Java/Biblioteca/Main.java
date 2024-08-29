package Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nombre, apellido;
        Persona persona = null;
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de la Biblioteca");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar catálogo");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:

                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el número de páginas del libro: ");
                    int numeroDePaginas = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    Libro libro = new Libro(titulo, autor, numeroDePaginas);
                    biblioteca.agregarLibro(libro);
                    System.out.println("Libro agregado al catálogo.");
                    break;
                case 2:
                    biblioteca.mostrarCatalogo();
                    break;
                case 3:
                    System.out.print("Ingrese su nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese su apellido: ");
                    apellido = scanner.nextLine();
                    persona = new Persona(nombre, apellido);
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestamo = scanner.nextLine();
                    if (biblioteca.prestarLibro(persona, tituloPrestamo)) {
                        System.out.println("Libro prestado exitosamente a " + persona.getNombreCompleto());
                    } else {
                        System.out.println("No se pudo prestar el libro. Verifique el título o el estado del libro.");
                    }
                    break;
                case 4:
                    // persona = new Persona(nombre, apellido);

                    System.out.print("Ingrese el título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    if (biblioteca.devolverLibro(persona, tituloDevolucion)) {
                        System.out.println("Libro devuelto exitosamente por " + persona.getNombreCompleto());
                    } else {
                        System.out.println("No se pudo devolver el libro. Verifique el título o el estado del libro.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
