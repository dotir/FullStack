public class SegundoPrograma {

    public static void main(String[] args) {
        System.out.println("Segundo programa em Java");

        //menu con opciones guardar,cargar y salir
        System.out.println("Menú de opciones");
        System.out.println("1. Calcular día de la semana");
        System.out.println("2. Calificar");
        System.out.println("3. Figura geométrica");
        System.out.println("4. Salir");
        System.out.println("Ingrese una opción: ");
        int opcion = Integer.parseInt(System.console().readLine());
        switch (opcion) {
            case 1:
            calculadiaSemana();
            break;
            case 2:
            calificacion();
            break;
            case 3:
            figuraGeometrica();
            break;
            case 4:
            System.out.println("Saliendo...");
            break;
            default:
            System.out.println("Opción no válida");
            break;
        }

    }

    public static void calculadiaSemana() {

        System.out.println("Ingrese un número del 1 al 7: ");
        int dia = Integer.parseInt(System.console().readLine());
        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("Día no válido");
                break;
        }
    }

    public static void calificacion() {
        System.out.println("Ingrese una calificación del 1 al 5: ");
        int calificacion = Integer.parseInt(System.console().readLine());
        switch (calificacion) {
            case 1:
                System.out.println("Muy deficiente");
                break;
            case 2:
                System.out.println("Deficiente");
                break;
            case 3:
                System.out.println("Suficiente");
                break;
            case 4:
                System.out.println("Notable");
                break;
            case 5:
                System.out.println("Sobresaliente");
                break;
            default:
                System.out.println("Calificación no válida");
                break;
        }
    }

    public static void menu() {
        int opcion = 0;
        do {
            System.out.println("Menú de opciones");
            System.out.println("1. Guardar");
            System.out.println("2. Cargar");
            System.out.println("3. Salir");
            System.out.println("Ingrese una opción: ");
            opcion = Integer.parseInt(System.console().readLine());
            switch (opcion) {
                case 1:
                    System.out.println("Guardando...");
                    break;
                case 2:
                    System.out.println("Cargando...");
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 3);
    }

    public static void figuraGeometrica() {
        System.out.println("Seleccione una figura geométrica: ");
        System.out.println("1. Circulo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triangulo");
        int opcion = Integer.parseInt(System.console().readLine());
        switch (opcion) {
            case 1:
                //solicitar datos para calular area de un circulo
                System.out.println("Ingrese el radio del círculo: ");
                double radio = Double.parseDouble(System.console().readLine());
                double area = Math.PI * Math.pow(radio, 2);
                System.out.println("El área del círculo es: " + area);
                break;
            case 2:
                //solicitar datos para calular area de un cuadrado
                System.out.println("Ingrese el lado del cuadrado: ");
                double lado = Double.parseDouble(System.console().readLine());
                double areaCuadrado = Math.pow(lado, 2);
                System.out.println("El área del cuadrado es: " + areaCuadrado);
                break;
            case 3:
                //solicitar datos para calular area de un triangulo
                System.out.println("Ingrese la base del triángulo: ");
                double base = Double.parseDouble(System.console().readLine());
                System.out.println("Ingrese la altura del triángulo: ");
                double altura = Double.parseDouble(System.console().readLine());
                double areaTriangulo = (base * altura) / 2;
                System.out.println("El área del triángulo es: " + areaTriangulo);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }


}
