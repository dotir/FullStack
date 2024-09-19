package ColeccionesArrays;

import java.util.ArrayList;

public class CiudadesArraylist {
    public static void main(String[] args) {

        ArrayList<String> ciudades = new ArrayList<String>();
        // Bucle que solicita al usuario nombres de ciudades
        String ciudad = "";
        while (!ciudad.equals("fin")) {
            System.out.println("Introduce nombre de ciudades. Para terminar escribe 'fin'");
            ciudad = System.console().readLine();
            if (!ciudad.equals("fin")) {
                ciudades.add(ciudad);
            }
        }

        // Bucle que muestra las ciudades almacenadas
        System.out.println("Las ciudades introducidas son:");
        for (String c : ciudades) {
            System.out.println("- " + c);
        }
    }
}