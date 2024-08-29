package Herencia;

public class Animal {
    //atributos
    private String nombre;
    private int edad;

    //constructor
    public Animal(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    //getters y setters
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    // Métodos
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }
}
