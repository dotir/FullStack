package ColeccionesArrays;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SistemaTurnos {
    private static ArrayList<Integer> turnos = new ArrayList<>();
    private static int siguienteTurno = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Obtener un número de turno");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Realizar sorteo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    obtenerTurno();
                    break;
                case 2:
                    atenderSiguienteCliente();
                    break;
                case 3:
                    realizarSorteo();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    // Método para obtener un número de turno
    public static void obtenerTurno() {
        turnos.add(siguienteTurno);
        System.out.println("Su número de turno es: " + siguienteTurno);
        siguienteTurno++;
    }

    // Método para atender al siguiente cliente
    public static void atenderSiguienteCliente() {
        if (!turnos.isEmpty()) {
            int turnoAtendido = turnos.remove(0);
            System.out.println("Atendiendo al cliente con turno: " + turnoAtendido);
        } else {
            System.out.println("No hay clientes en espera.");
        }
    }

    // Método para realizar un sorteo
    public static void realizarSorteo() {
        if (!turnos.isEmpty()) {
            Random random = new Random();
            int indiceSorteado = random.nextInt(turnos.size());
            int turnoSorteado = turnos.remove(indiceSorteado);
            System.out.println("Sorteo realizado. Atendiendo al cliente con turno: " + turnoSorteado);
        } else {
            System.out.println("No hay clientes en espera para el sorteo.");
        }
    }
}
