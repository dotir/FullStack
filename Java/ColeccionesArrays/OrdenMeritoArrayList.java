package ColeccionesArrays;

import java.util.ArrayList;

public class OrdenMeritoArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> notas = new ArrayList<Integer>();
        // Bucle que solicita al usuario notas
        Integer nota = 0;
        while (nota != -1) {
            System.out.println("Introduce notas. Para terminar escribe '-1'");
            nota = Integer.parseInt(System.console().readLine());
            if (nota != -1) {
                if (nota < 0 || nota > 10) {
                    System.out.println("La nota debe estar entre 0 y 10");
                } else {
                    notas.add(nota);
                }
            }
        }

        // Bucle que muestra las notas almacenadas
        System.out.println("Las notas introducidas son:");
        for (Integer n : notas) {
            System.out.println("- " + n);
        }
    }
}
