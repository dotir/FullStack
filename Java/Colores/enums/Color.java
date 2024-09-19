package Colores.enums;

public enum Color {

    ROJO("#FF0000"), 
    AMARILLO("#FFFF00"), 
    AZUL("#0000FF");

    //propiedad valorhexadecimal
    private String valorHexadecimal;

    //constructor
    Color(String valorHexadecimal) {
        this.valorHexadecimal = valorHexadecimal;
    }

    //getter
    public String getValorHexadecimal() {
        return valorHexadecimal;
    }

}
