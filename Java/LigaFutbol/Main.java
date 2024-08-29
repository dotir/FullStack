package LigaFutbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Jugador> jugadores = new ArrayList<>();
    private static List<Equipo> equipos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearJugador();
                    break;
                case 2:
                    crearEquipo();
                    break;
                case 3:
                    asignarJugadorAEquipo();
                    break;
                case 4:
                    mostrarListaDeJugadores();
                    break;
                case 5:
                    mostrarListaDeEquipos();
                    break;
                case 6:
                    eliminarJugador();
                    break;
                case 7:
                    eliminarEquipo();
                    break;
                case 8:
                    seleccionarJugador();
                    break;
                case 9:
                    seleccionarEquipo();
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Crear jugador");
        System.out.println("2. Crear equipo");
        System.out.println("3. Asignar jugador a equipo");
        System.out.println("4. Mostrar lista de jugadores");
        System.out.println("5. Mostrar lista de equipos");
        System.out.println("6. Eliminar jugador");
        System.out.println("7. Eliminar equipo");
        System.out.println("8. Seleccionar jugador");
        System.out.println("9. Seleccionar equipo");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void crearJugador() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles para asignar un jugador.");
            return;
        }
        System.out.println("Seleccione un equipo para asignar el nuevo jugador:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indiceEquipo = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Equipo equipo = equipos.get(indiceEquipo);

        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        Jugador jugador = new Jugador(nombre,equipo);
        jugadores.add(jugador);
        System.out.println("Jugador creado exitosamente.");
    }

    private static void crearEquipo() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = scanner.nextLine();
        Equipo equipo = new Equipo(nombre);
        equipos.add(equipo);
        System.out.println("Equipo creado exitosamente.");
    }

    private static void asignarJugadorAEquipo() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
            return;
        }
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles.");
            return;
        }

        System.out.println("Seleccione un jugador:");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + ". " + jugadores.get(i).getNombre());
        }
        int indiceJugador = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Seleccione un equipo:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indiceEquipo = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Equipo equipo = equipos.get(indiceEquipo);
        Jugador jugador = jugadores.get(indiceJugador);
        equipo.agregarJugador(jugador);
        System.out.println("Jugador asignado al equipo exitosamente.");
    }

    private static void mostrarListaDeJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    private static void mostrarListaDeEquipos() {
        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }

    private static void eliminarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
            return;
        }

        System.out.println("Seleccione un jugador para eliminar:");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + ". " + jugadores.get(i).getNombre());
        }
        int indiceJugador = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Jugador jugador = jugadores.get(indiceJugador);
        if (jugador.getEquipo() != null) {
            jugador.getEquipo().eliminarJugador(jugador);
        }
        jugadores.remove(indiceJugador);
        System.out.println("Jugador eliminado exitosamente.");
    }

    private static void eliminarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles.");
            return;
        }

        System.out.println("Seleccione un equipo para eliminar:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indiceEquipo = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Equipo equipo = equipos.get(indiceEquipo);
        for (Jugador jugador : equipo.getJugadores()) {
            jugador.setEquipo(null);
        }
        equipos.remove(indiceEquipo);
        System.out.println("Equipo eliminado exitosamente.");
    }

    private static void seleccionarJugador() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores disponibles.");
            return;
        }

        System.out.println("Seleccione un jugador:");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.println((i + 1) + ". " + jugadores.get(i).getNombre());
        }
        int indiceJugador = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Jugador jugador = jugadores.get(indiceJugador);
        while (true) {
            mostrarSubMenuJugador(jugador);
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println(jugador);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nombre del jugador: ");
                    String nuevoNombre = scanner.nextLine();
                    jugador.setNombre(nuevoNombre);
                    System.out.println("Nombre del jugador cambiado exitosamente.");
                    break;
                case 3:
                    if (equipos.isEmpty()) {
                        System.out.println("No hay equipos disponibles.");
                        break;
                    }
                    System.out.println("Seleccione un nuevo equipo:");
                    for (int i = 0; i < equipos.size(); i++) {
                        System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
                    }
                    int indiceEquipo = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir el salto de línea

                    Equipo nuevoEquipo = equipos.get(indiceEquipo);
                    if (jugador.getEquipo() != null) {
                        jugador.getEquipo().eliminarJugador(jugador);
                    }
                    nuevoEquipo.agregarJugador(jugador);
                    System.out.println("Equipo del jugador cambiado exitosamente.");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarSubMenuJugador(Jugador jugador) {
        System.out.println("Submenú Jugador (" + jugador.getNombre() + "):");
        System.out.println("1. Ver detalles");
        System.out.println("2. Cambiar nombre");
        System.out.println("3. Cambiar equipo");
        System.out.println("4. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    private static void seleccionarEquipo() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos disponibles.");
            return;
        }

        System.out.println("Seleccione un equipo:");
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println((i + 1) + ". " + equipos.get(i).getNombre());
        }
        int indiceEquipo = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        Equipo equipo = equipos.get(indiceEquipo);
        while (true) {
            mostrarSubMenuEquipo(equipo);
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println(equipo);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo nombre del equipo: ");
                    String nuevoNombre = scanner.nextLine();
                    equipo.setNombre(nuevoNombre);
                    System.out.println("Nombre del equipo cambiado exitosamente.");
                    break;
                case 3:
                    if (jugadores.isEmpty()) {
                        System.out.println("No hay jugadores disponibles.");
                        break;
                    }
                    System.out.println("Seleccione un jugador para agregar al equipo:");
                    for (int i = 0; i < jugadores.size(); i++) {
                        System.out.println((i + 1) + ". " + jugadores.get(i).getNombre());
                    }
                    int indiceJugador = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir el salto de línea

                    Jugador jugadorParaAgregar = jugadores.get(indiceJugador); // Renombramos la variable
                    equipo.agregarJugador(jugadorParaAgregar);
                    System.out.println("Jugador agregado al equipo exitosamente.");
                    break;

                case 4:
                    System.out.println("Jugadores del equipo " + equipo.getNombre() + ":");
                    for (Jugador jugadorEnEquipo : equipo.getJugadores()) { // Renombramos la variable aquí también
                        System.out.println(jugadorEnEquipo);
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarSubMenuEquipo(Equipo equipo) {
        System.out.println("Submenú Equipo (" + equipo.getNombre() + "):");
        System.out.println("1. Ver detalles");
        System.out.println("2. Cambiar nombre");
        System.out.println("3. Agregar jugador al equipo");
        System.out.println("4. Mostrar jugadores del equipo");
        System.out.println("5. Regresar al menú principal");
        System.out.print("Seleccione una opción: ");
    }
}