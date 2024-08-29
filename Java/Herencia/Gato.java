package Herencia;

public class Gato extends Animal{
    private String color;

    // Constructor
    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }

    // Métodos sobrescritos
    @Override
    public void comer() {
        System.out.println("El gato " + getNombre() + " está comiendo pescado.");
    }

    @Override
    public void dormir() {
        System.out.println("El gato " + getNombre() + " está durmiendo encima del sofá.");
    }

    // Métodos
    public void maullar() {
        System.out.println(getNombre() + " está maullando.");
    }

    // Getters y Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
