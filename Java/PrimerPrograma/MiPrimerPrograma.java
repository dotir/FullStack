import java.util.Scanner;

public class MiPrimerPrograma {

    static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Saludar");
            System.out.println("2. Tres Variables");
            System.out.println("3. Datos");
            System.out.println("4. Pedir Datos");
            System.out.println("5. Calculadora");
            System.out.println("6. Comparaciones");
            System.out.println("7. Verificar edad");
            System.out.println("8. Calcular area y perimetro de un rectangulo");
            System.out.println("9. Calcular si es par o impar");
            System.out.println("10. Calculadora basica con menu");
            System.out.println("11. Determinar si un numero es positivo, negativo o cero");
            System.out.println("12. Escala de calificaciones");
            System.out.println("13. Calcular si un numero es divisible por 5, por 3 o por ambos o por ninguno");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    saludar();
                    break;
                case 2:
                    tresVariables();
                    break;
                case 3:
                    datos();
                    break;
                case 4:
                    pedirDatos();
                    break;
                case 5:
                    calculadora();
                    break;
                case 6:
                    comparaciones();
                    break;
                case 7:
                    verificarEdad();
                    break;
                case 8:
                    calcularAreaPerimetroRectangulo();
                    break;
                case 9:
                    calcularParImpar();
                    break;
                case 10:
                    CalculadoraBasica();
                    break;
                case 11:
                    determinarPositivoNegativoCero();
                    break;
                case 12:
                    calcularEscalaCalificaciones();
                    break;
                case 13:
                    divisiblePor5o3();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 0);

    }

    public static void saludar() {
        System.out.println("Hola Mundo");
    }

    public static void tresVariables() {
        int a = 10;
        String b = "Hola";
        float c = 3.14f;
        System.out.println("El valor de a es: " + a);
        System.out.println("El valor de b es: " + b);
        System.out.println("El valor de c es: " + c);
    }

    public static void datos() {
        String nombre = "Irving";
        int edad = 28;
        System.out.println("Mi nombre es: " + nombre + " y tengo " + edad + " años");
    }

    public static void pedirDatos() {
        sc = new Scanner(System.in);
        System.out.println("Escribe tu nombre: ");
        String nombre = sc.next();
        System.out.println("Escribe tu edad: ");
        int edad = sc.nextInt();
        System.out.println("Tu nombre es: " + nombre + " y tienes " + edad + " años");
    }

    public static void calculadora() {
        sc = new Scanner(System.in);
        System.out.println("Escribe el primer número: ");
        int a = sc.nextInt();
        System.out.println("Escribe el segundo número: ");
        int b = sc.nextInt();
        System.out.println("La suma de " + a + " + " + b + " es: " + (a + b));
        System.out.println("La resta de " + a + " - " + b + " es: " + (a - b));
        System.out.println("La multiplicación de " + a + " * " + b + " es: " + (a * b));
        System.out.println("La división de " + a + " / " + b + " es: " + (a / b));
        System.out.println("El módulo de " + a + " % " + b + " es: " + (a % b));
    }

    public static void comparaciones() {
        sc = new Scanner(System.in);
        System.out.println("Escribe el primer número: ");
        int a = sc.nextInt();
        System.out.println("Escribe el segundo número: ");
        int b = sc.nextInt();
        if (a > b) {
            System.out.println(a + " es mayor que " + b);
        } else if (a < b) {
            System.out.println(a + " es menor que " + b);
        } else {
            System.out.println(a + " es igual a " + b);
        }
        // verificar si el primer numero es divisible por 2
        if (a % 2 == 0) {
            System.out.println(a + " es divisible por 2");
        } else {
            System.out.println(a + " no es divisible por 2");
        }
        //pedir que ingrese otros 2 numeros
        System.out.println("Escribe el tercer número: ");
        int c = sc.nextInt();
        System.out.println("Escribe el cuarto número: ");
        int d = sc.nextInt();
        //verificar si el tercer numero es mayor o igual al cuarto numero
        if (c >= d) {
            System.out.println(c + " es mayor o igual que " + d);
        } else {
            System.out.println(c + " es menor que " + d);
        }
    }

    public static void verificarEdad() {
        final int ANIOACTUAL = 2024;
        sc = new Scanner(System.in);
        System.out.println("Escribe tu año de nacimiento: ");
        int anioNacimiento = sc.nextInt();
        int edad = ANIOACTUAL - anioNacimiento;
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
    }

    public static void calcularAreaPerimetroRectangulo() {
        sc = new Scanner(System.in);
        System.out.println("Escribe la base del rectángulo: ");
        int base = sc.nextInt();
        System.out.println("Escribe la altura del rectángulo: ");
        int altura = sc.nextInt();
        int area = base * altura;
        int perimetro = 2 * (base + altura);
        System.out.println("El área del rectángulo es: " + area);
        System.out.println("El perímetro del rectángulo es: " + perimetro);
    }

    public static void calcularParImpar() {
        sc = new Scanner(System.in);
        System.out.println("Escribe un número: ");
        int numero = sc.nextInt();
        if (numero % 2 == 0) {
            System.out.println(numero + " es par");
        } else {
            System.out.println(numero + " es impar");
        }
    }

    public static void CalculadoraBasica() {
        sc = new Scanner(System.in);
        int opcion;
        int a, b;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Escribe el primer número: ");
                    a = sc.nextInt();
                    System.out.println("Escribe el segundo número: ");
                    b = sc.nextInt();
                    System.out.println("La suma de " + a + " + " + b + " es: " + (a + b));
                    break;
                case 2:
                    System.out.println("Escribe el primer número: ");
                    a = sc.nextInt();
                    System.out.println("Escribe el segundo número: ");
                    b = sc.nextInt();
                    System.out.println("La resta de " + a + " - " + b + " es: " + (a - b));
                    break;
                case 3:
                    System.out.println("Escribe el primer número: ");
                    a = sc.nextInt();
                    System.out.println("Escribe el segundo número: ");
                    b = sc.nextInt();
                    System.out.println("La multiplicación de " + a + " * " + b + " es: " + (a * b));
                    break;
                case 4:
                    System.out.println("Escribe el primer número: ");
                    a = sc.nextInt();
                    System.out.println("Escribe el segundo número: ");
                    b = sc.nextInt();
                    System.out.println("La división de " + a + " / " + b + " es: " + (a / b));
                    break;
                case 0:
                    System.out.println("Saliendo de la calculadora...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);
    }

    public static void determinarPositivoNegativoCero() {
        sc = new Scanner(System.in);
        System.out.println("Escribe un número: ");
        int numero = sc.nextInt();
        if (numero > 0) {
            System.out.println(numero + " es positivo");
        } else if (numero < 0) {
            System.out.println(numero + " es negativo");
        } else {
            System.out.println(numero + " es cero");
        }
    }

    public static void calcularEscalaCalificaciones() {
        sc = new Scanner(System.in);
        System.out.println("Escribe tu calificación del 0 al 100: ");
        int calificacion = sc.nextInt();
        if (calificacion >= 0 && calificacion <= 100) {
            if (calificacion >= 90) {
                System.out.println("Tu calificación es A");
            } else if (calificacion >= 80) {
                System.out.println("Tu calificación es B");
            } else if (calificacion >= 70) {
                System.out.println("Tu calificación es C");
            } else if (calificacion >= 60) {
                System.out.println("Tu calificación es D");
            } else {
                System.out.println("Tu calificación es F");
            }
        } else {
            System.out.println("Calificación inválida. Intente nuevamente.");
        }
    }

    public static void divisiblePor5o3() {
        sc = new Scanner(System.in);
        System.out.println("Escribe un número: ");
        int numero = sc.nextInt();
        if (numero % 5 == 0 && numero % 3 == 0) {
            System.out.println(numero + " es divisible por 5 y por 3");
        } else if (numero % 5 == 0) {
            System.out.println(numero + " es divisible por 5");
        } else if (numero % 3 == 0) {
            System.out.println(numero + " es divisible por 3");
        } else {
            System.out.println(numero + " no es divisible por 5 ni por 3");
        }
    }
}