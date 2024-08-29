package Herencia;

import java.util.Objects;

public class Perro extends Animal{
    private String raza;

    // Constructor
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    // Métodos sobrescritos
    @Override
    public void comer() {
        System.out.println("El perro " + getNombre() + " está comiendo croquetas.");
    }

    @Override
    public void dormir() {
        System.out.println("El perro " + getNombre() + " está durmiendo en su cama.");
    }

    // Métodos
    public void ladrar() {
        System.out.println(getNombre() + " está ladrando.");
    }

    // Sobrescribir equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perro perro = (Perro) o;
        return raza.equals(perro.raza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raza);
    }

    // Getters y Setters
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
