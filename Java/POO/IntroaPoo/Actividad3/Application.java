package POO.IntroaPoo.Actividad3;

import java.util.Scanner;
import POO.IntroaPoo.Actividad3.entidad.Rectangulo;

public class Application {
    // menú interactivo que permita al usuario crear instancias de 'Rectangulo' y
    // acceder a sus métodos para obtener información relevante
    public static void main(String[] args) {
        // hacer un menu para que el usuario pueda ingresar los datos
        Scanner scanner = new Scanner(System.in);
        Rectangulo rectangulo = null;

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear Rectangulo con ancho y alto");
            System.out.println("2. Calcular Area");
            System.out.println("3. Calcular Perimetro");
            System.out.println("4. Imprimir Area");
            System.out.println("5. Imprimir Perimetro");
            System.out.println("6. Imprimir contador de rectangulos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ancho: ");
                    double ancho = scanner.nextDouble();
                    System.out.print("Ingrese el alto: ");
                    double alto = scanner.nextDouble();
                    rectangulo = new Rectangulo(ancho, alto);
                    break;
                case 2:
                    if (rectangulo != null) {
                        System.out.println("El area del rectangulo es: " + rectangulo.Area());
                    } else {
                        System.out.println("No se ha creado ningún Rectangulo.");
                    }
                    break;
                case 3:
                    if (rectangulo != null) {
                        System.out.println("El perimetro del rectangulo es: " + rectangulo.Perimetro());
                    } else {
                        System.out.println("No se ha creado ningún Rectangulo.");
                    }
                    break;
                case 4:
                    if (rectangulo != null) {
                        rectangulo.ImprimirArea();
                    } else {
                        System.out.println("No se ha creado ningún Rectangulo.");
                    }
                    break;
                case 5:
                    if (rectangulo != null) {
                        rectangulo.ImprimirPerimetro();
                    } else {
                        System.out.println("No se ha creado ningún Rectangulo.");
                    }
                    break;
                case 6:
                    Rectangulo.ImprimirContador();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");

            }
        }
    }

}
