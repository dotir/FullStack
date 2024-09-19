package Colores;

import Colores.enums.Color;

public class ConvertidorColor {
    public Color convertirHexadecimal(String valorHexadecimal) {
        for (Color color : Color.values()) {
            if (color.getValorHexadecimal().equalsIgnoreCase(valorHexadecimal)) {
                return color;
            }
        }
        return null;
    }
}
