package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> catalogo;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        this.catalogo.add(libro);
    }

    public void mostrarCatalogo() {
        if (catalogo.isEmpty()) {
            System.out.println("El catálogo está vacío.");
        } else {
            for (Libro libro : catalogo) {
                libro.mostrarInformación();
                System.out.println("-------------------------");
            }
        }
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : catalogo) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public boolean prestarLibro(Persona persona, String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null && !libro.isPrestado()) {
            libro.setPrestado(true);
            persona.agregarLibroPrestado(libro);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Persona persona, String titulo) {
        Libro libro = buscarLibroPorTitulo(titulo);
        if (libro != null && libro.isPrestado() && persona.getLibrosPrestados().contains(libro)) {
            libro.setPrestado(false);
            persona.devolverLibro(libro);
            return true;
        }
        return false;
    }
}
