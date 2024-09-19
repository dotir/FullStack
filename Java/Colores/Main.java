package Colores;

import Colores.enums.Color;

public class Main {
    public static void main(String[] args) {
        ConvertidorColor convertidor = new ConvertidorColor();

        String[] coloresHexadecimales = {"#FF0000", "#FFFF00", "#0000FF", "#00FF00", "#FFA500"};

        for (String colorHex : coloresHexadecimales) {
            Color color = convertidor.convertirHexadecimal(colorHex);
            if (color != null) {
                System.out.println("El color es: " + color);
            } else {
                System.out.println("No es un color primario");
            }
        }
    }
}
