package POO.Encapsulamiento.figurasgeometricas;

import java.util.Scanner;

import POO.Encapsulamiento.figurasgeometricas.modelos.Circulo;
import POO.Encapsulamiento.figurasgeometricas.modelos.Rectangulo;
import POO.Encapsulamiento.figurasgeometricas.modelos.Triangulo;

public class Application {
    // hacer un menu para que el usuario pueda ingresar los datos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rectangulo rectangulo = null;
        Circulo circulo = null;
        Triangulo triangulo = null;

        // menu tenga las opciones de crear un rectangulo,Circulo,Triangulo
        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear Rectangulo con ancho y alto");
            System.out.println("2. Crear Circulo con radio");
            System.out.println("3. Crear Triangulo con base y altura");
            System.out.println("4. Calcular Area");
            System.out.println("5. Calcular Perimetro");
            System.out.println("6. Imprimir Area");
            System.out.println("7. Imprimir Perimetro");
            System.out.println("8. Salir");
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
                    System.out.print("Ingrese el radio: ");
                    double radio = scanner.nextDouble();
                    circulo = new Circulo(radio);
                    break;
                case 3:
                    System.out.print("Ingrese la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura: ");
                    double altura = scanner.nextDouble();
                    triangulo = new Triangulo(base, altura);
                    break;
                case 4:
                    if (rectangulo != null) {
                        System.out.println("El area del rectangulo es: " + rectangulo.Area());
                    } else if (circulo != null) {
                        System.out.println("El area del circulo es: " + circulo.Area());
                    } else if (triangulo != null) {
                        System.out.println("El area del triangulo es: " + triangulo.Area());
                    } else {
                        System.out.println("No se ha creado ninguna figura.");
                    }
                    break;
                case 5:
                    if (rectangulo != null) {
                        System.out.println("El perimetro del rectangulo es: " + rectangulo.Perimetro());
                    } else if (circulo != null) {
                        System.out.println("El perimetro del circulo es: " + circulo.Perimetro());
                    } else if (triangulo != null) {
                        System.out.println("El perimetro del triangulo es: " + triangulo.Perimetro());
                    } else {
                        System.out.println("No se ha creado ninguna figura.");
                    }
                    break;
                case 6:
                    if (rectangulo != null) {
                        rectangulo.ImprimirArea();
                    } else if (circulo != null) {
                        circulo.ImprimirArea();
                    } else if (triangulo != null) {
                        triangulo.ImprimirArea();
                    } else {
                        System.out.println("No se ha creado ninguna figura.");
                    }
                    break;
                case 7:
                    if (rectangulo != null) {
                        rectangulo.ImprimirPerimetro();
                    } else if (circulo != null) {
                        circulo.ImprimirPerimetro();
                    } else if (triangulo != null) {
                        triangulo.ImprimirPerimetro();
                    } else {
                        System.out.println("No se ha creado ninguna figura.");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");

            }

        }
    }
}