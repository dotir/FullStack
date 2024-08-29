package Herencia;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();

        // Agregar objetos a la lista
        animales.add(new Perro("Buddy", 3, "Golden Retriever"));
        animales.add(new Gato("Whiskers", 2, "Gris"));
        animales.add(new Perro("Max", 4, "Labrador"));
        animales.add(new Gato("Mittens", 1, "Blanco"));
        animales.add(new Perro("Rocky", 5, "Bulldog"));
        animales.add(new Gato("Simba", 3, "Naranja"));
        animales.add(new Perro("Daisy", 2, "Beagle"));
        animales.add(new Gato("Luna", 2, "Negro"));
        animales.add(new Perro("Charlie", 6, "Dachshund"));
        animales.add(new Gato("Oliver", 1, "Atigrado"));

        // Recorrer la lista y ejecutar métodos
        for (Animal animal : animales) {
            if (animal instanceof Perro) {
                Perro perro = (Perro) animal;
                System.out.println("Es un perro: " + perro.getNombre());
                perro.comer();
                perro.dormir();
                perro.ladrar();
            } else if (animal instanceof Gato) {
                Gato gato = (Gato) animal;
                System.out.println("Es un gato: " + gato.getNombre());
                gato.comer();
                gato.dormir();
                gato.maullar();
            }
        }
    }
}
