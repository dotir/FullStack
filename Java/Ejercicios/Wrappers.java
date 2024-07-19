import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Wrappers {

    public static void main(String[] args) {

        // 1. Verificar si una cadena representa un número valido
        // Actividad1();

        // 2. Convertir de cadena a numero
        // Actividad2();

        // 3. verificar si una cadena contiene solo letras
        // Actividad3();

        // 4. Contar espacios en blanco en una cadena
        // Actividad4();

        // 5. Contando los digitos en un numero
        // Actividad5();

        // DESAFIOS 1
        // 1. Generando Contraseñas
        // GenerarContrasena();

        // 2. Estadisticas de calificaciones
        // EstadisticasCalificaciones();

        // 3. Fibonacci
        // Fibonacci();

        // 4. Números primos
        NumerosPrimos();
    }

    public static void Actividad1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        String numero = sc.nextLine();
        try {
            Double.valueOf(numero);
            System.out.println("El valor ingresado es un número");
        } catch (NumberFormatException nfe) {
            System.out.println("El valor ingresado no es un número válido");
        }
        sc.close();
    }

    public static void Actividad2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número entero: ");
        String input = sc.nextLine();

        try {
            int number = Integer.parseInt(input);
            System.out.println("El número entero es: " + number);
        } catch (NumberFormatException e) {
            System.out.println("La entrada no es un número entero válido.");
        }
        sc.close();
    }

    public static void Actividad3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto: ");
        String input = sc.nextLine();
        boolean soloLetras = true;

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                soloLetras = false;
                break;
            }
        }

        if (soloLetras) {
            System.out.println("La cadena contiene solo letras.");
        } else {
            System.out.println("La cadena contiene caracteres no válidos.");
        }
        sc.close();
    }

    public static void Actividad4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una cadena de texto: ");
        String cadena = sc.nextLine();
        int contadorEspacios = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isWhitespace(cadena.charAt(i))) {
                contadorEspacios++;
            }
        }
        sc.close();
        System.out.println("Número de espacios en blanco: " + contadorEspacios);
    }

    public static void Actividad5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un número: ");
        int numero = sc.nextInt();
        String numeroComoCadena = String.valueOf(numero);
        int contadorDigitos = 0;

        for (int i = 0; i < numeroComoCadena.length(); i++) {
            if (Character.isDigit(numeroComoCadena.charAt(i))) {
                contadorDigitos++;
            }
        }
        sc.close();
        System.out.println("El número de dígitos en el número es: " + contadorDigitos);
    }

    public static void GenerarContrasena() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la longitud de la contraseña: ");
        int longitud = sc.nextInt();
        char[] contrasena = new char[longitud];

        // Inicializar contadores para asegurar al menos un carácter de cada tipo
        int mayusculas = 0, minusculas = 0, digitos = 0;

        for (int i = 0; i < longitud; i++) {
            // Generar un carácter aleatorio y verificar su tipo
            char caracter;
            do {
                caracter = (char) ((int) (Math.random() * 94) + 33); // ASCII imprimible desde 33 hasta 126
                if (Character.isUpperCase(caracter) && mayusculas == 0) {
                    mayusculas++;
                } else if (Character.isLowerCase(caracter) && minusculas == 0) {
                    minusculas++;
                } else if (Character.isDigit(caracter) && digitos == 0) {
                    digitos++;
                }
            } while ((mayusculas + minusculas + digitos) < 3 || (mayusculas == 0 || minusculas == 0 || digitos == 0));

            contrasena[i] = caracter;

            // Reiniciar contadores si se han cumplido los requisitos mínimos y aún quedan
            // caracteres por generar
            if (i < longitud - 1 && (mayusculas + minusculas + digitos) >= 3) {
                mayusculas = minusculas = digitos = 0;
            }
        }

        // Convertir el arreglo de caracteres en un String
        StringBuilder contrasenaStr = new StringBuilder();
        for (char c : contrasena) {
            contrasenaStr.append(c);
        }
        sc.close();
        System.out.println("Contraseña generada: " + contrasenaStr);
    }

    public static void EstadisticasCalificaciones() {
        // Generar arreglo de calificaciones aleatorias
        String[] calificaciones = generarCalificacionesAleatorias(10); // Genera 10 calificaciones aleatorias

        // Separar calificaciones
        ArrayList<Double> desaprobados = new ArrayList<>();
        ArrayList<Double> aprobados = new ArrayList<>();
        ArrayList<Double> excelentes = new ArrayList<>();
        double sumaTotal = 0;

        for (String calificacion : calificaciones) {
            double calif = Double.parseDouble(calificacion);
            sumaTotal += calif;

            if (calif < 4) {
                desaprobados.add(calif);
            } else if (calif >= 4 && calif < 10) {
                aprobados.add(calif);
            } else {
                excelentes.add(calif);
            }
        }

        // Calcular promedios
        double promedioTotal = sumaTotal / calificaciones.length;
        double promedioDesaprobados = calcularPromedio(desaprobados);
        double promedioAprobados = calcularPromedio(aprobados);
        double promedioExcelentes = calcularPromedio(excelentes);

        // Imprimir resultados
        System.out.println("Calificaciones originales: ");
        imprimirArreglo(calificaciones);
        System.out.println("Promedio total: " + promedioTotal);
        System.out.println("Desaprobados: " + desaprobados + " - Promedio: " + promedioDesaprobados);
        System.out.println("Aprobados: " + aprobados + " - Promedio: " + promedioAprobados);
        System.out.println("Excelentes: " + excelentes + " - Promedio: " + promedioExcelentes);
    }

    public static String[] generarCalificacionesAleatorias(int cantidad) {
        String[] calificaciones = new String[cantidad];
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            // Genera calificaciones entre 0 y 12
            calificaciones[i] = String.format("%.2f", random.nextDouble() * 12);
        }
        return calificaciones;
    }

    public static double calcularPromedio(ArrayList<Double> lista) {
        if (lista.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (double num : lista) {
            suma += num;
        }
        return suma / lista.size();
    }

    public static void imprimirArreglo(String[] arreglo) {
        for (String elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void Fibonacci() {
        int n = 8; // Número de términos a imprimir
        int primerTermino = 0;
        int segundoTermino = 1;
        int contador = 0;

        while (contador < n) {
            System.out.print(primerTermino + " ");
            // Calcular el siguiente término de la serie
            int siguienteTermino = primerTermino + segundoTermino;
            primerTermino = segundoTermino;
            segundoTermino = siguienteTermino;

            contador++;
        }
    }

    public static void NumerosPrimos(){

        Scanner sc = new Scanner(System.in);
        int numero;

        do {
            System.out.println("Ingrese un número (0 para salir): ");
            numero = sc.nextInt();

            if (numero == 0) {
                System.out.println("Programa finalizado.");
                break;
            }

            if (esPrimo(numero)) {
                System.out.println(numero + " es un número primo.");
            } else {
                System.out.println(numero + " no es un número primo. Intente de nuevo.");
            }
        } while (!esPrimo(numero) || numero != 0);

        sc.close();

    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        int contador = 2;
        boolean primo = true;

        while ((primo) && (contador != numero)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

}