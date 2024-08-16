package POO.IntroaPoo.Complementario;

import java.util.Scanner;

public class Applicarion {
    public static void main(String[] args) {
        // hacer un menu para que el usuario pueda ingresar los datos
        Scanner scanner = new Scanner(System.in);
        Auto auto = null;

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear Auto con marca, modelo y año");
            System.out.println("2. Crear Auto con marca y modelo");
            System.out.println("3. Crear Auto con marca");
            System.out.println("4. Crear Auto sin parámetros");
            System.out.println("5. Imprimir datos del Auto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ingrese el año: ");
                    int año = scanner.nextInt();
                    auto = new Auto(marca, modelo, año);
                    break;
                case 2:
                    System.out.print("Ingrese la marca: ");
                    marca = scanner.nextLine();
                    System.out.print("Ingrese el modelo: ");
                    modelo = scanner.nextLine();
                    auto = new Auto(marca, modelo);
                    break;
                case 3:
                    System.out.print("Ingrese la marca: ");
                    marca = scanner.nextLine();
                    auto = new Auto(marca);
                    break;
                case 4:
                    auto = new Auto();
                    break;
                case 5:
                    if (auto != null) {
                        auto.imprimirDatos();
                    } else {
                        System.out.println("No se ha creado ningún Auto.");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");

            }
        }

    }
}