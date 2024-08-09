package Metodos2;

import java.util.Scanner;

public class FigurasGeometricas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionFigura, opcionCalculo;

        do {
            opcionFigura = menuFigura(scanner);
            if (opcionFigura == 4) {
                System.out.println("Saliendo del programa...");
                break;
            }

            opcionCalculo = menuCalculo(scanner);

            switch (opcionFigura) {
                case 1: // Círculo
                    calcularCirculo(scanner, opcionCalculo);
                    break;
                case 2: // Triángulo
                    calcularTriangulo(scanner, opcionCalculo);
                    break;
                case 3: // Paralelogramo
                    calcularParalelogramo(scanner, opcionCalculo);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcionFigura != 4);

        scanner.close();
    }

    public static int menuFigura(Scanner scanner) {
        System.out.println("Seleccione la figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Triángulo");
        System.out.println("3. Paralelogramo");
        System.out.println("4. Salir");
        return scanner.nextInt();
    }

    public static int menuCalculo(Scanner scanner) {
        System.out.println("Seleccione qué desea calcular:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        return scanner.nextInt();
    }

    public static void calcularCirculo(Scanner scanner, int opcionCalculo) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble();

        if (opcionCalculo == 1) {
            double area = Math.PI * Math.pow(radio, 2);
            System.out.printf("El área del círculo es: %.2f\n", area);
        } else if (opcionCalculo == 2) {
            double perimetro = 2 * Math.PI * radio;
            System.out.printf("El perímetro del círculo es: %.2f\n", perimetro);
        }
    }

    public static void calcularTriangulo(Scanner scanner, int opcionCalculo) {
        if (opcionCalculo == 1) {
            System.out.print("Ingrese la base del triángulo: ");
            double base = scanner.nextDouble();
            System.out.print("Ingrese la altura del triángulo: ");
            double altura = scanner.nextDouble();
            double area = (base * altura) / 2;
            System.out.printf("El área del triángulo es: %.2f\n", area);
        } else if (opcionCalculo == 2) {
            System.out.print("Ingrese la longitud del lado a: ");
            double a = scanner.nextDouble();
            System.out.print("Ingrese la longitud del lado b: ");
            double b = scanner.nextDouble();
            System.out.print("Ingrese la longitud del lado c: ");
            double c = scanner.nextDouble();
            double perimetro = a + b + c;
            System.out.printf("El perímetro del triángulo es: %.2f\n", perimetro);
        }
    }

    public static void calcularParalelogramo(Scanner scanner, int opcionCalculo) {
        if (opcionCalculo == 1) {
            System.out.print("Ingrese la base del paralelogramo: ");
            double base = scanner.nextDouble();
            System.out.print("Ingrese la altura del paralelogramo: ");
            double altura = scanner.nextDouble();
            double area = base * altura;
            System.out.printf("El área del paralelogramo es: %.2f\n", area);
        } else if (opcionCalculo == 2) {
            System.out.print("Ingrese la longitud del lado a: ");
            double a = scanner.nextDouble();
            System.out.print("Ingrese la longitud del lado b: ");
            double b = scanner.nextDouble();
            double perimetro = 2 * (a + b);
            System.out.printf("El perímetro del paralelogramo es: %.2f\n", perimetro);
        }
    }
}
