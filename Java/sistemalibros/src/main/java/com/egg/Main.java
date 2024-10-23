package com.egg;

import com.egg.entidades.Autor;
import com.egg.entidades.Libro;
import com.egg.servicios.AutorServicio;
import com.egg.servicios.LibroServicio;
import com.egg.servicios.EditorialServicio;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AutorServicio autorServicio = new AutorServicio();
        LibroServicio libroServicio = new LibroServicio();
        EditorialServicio editorialServicio = new EditorialServicio();

        // Crear un autor
        // autorServicio.crearAutor("Gabriel García Márquez");
        // Crear un libro
        // libroServicio.crearLibro("Cien años de soledad", "9780307474728", 1967, 100);
        // Crear una editorial
        // editorialServicio.crearEditorial("Planeta");

        // // Buscar autores por nombre
        // List<Autor> autores = autorServicio.buscarAutoresPorNombre("García");

        // // Mostrar resultados
        // for (Autor autor : autores) {
        // System.out.println("Autor encontrado: " + autor.getNombre());
        // }

        // // Buscar libro por ISBN
        // Libro libro = libroServicio.buscarLibroPorISBN("9780307474728");
        // System.out.println("Libro encontrado: " + libro.getTitulo());

        // // Buscar libros por título
        // List<Libro> libros = libroServicio.buscarLibrosPorTitulo("Cien años");
        // // Mostrar resultados
        // for (Libro libro : libros) {
        // System.out.println("Libro encontrado: " + libro.getTitulo());
        // }

        // Buscar libros por editorial
        List<Libro> libros = libroServicio.buscarLibrosPorEditorial("Planeta");

        // Mostrar resultados
        for (Libro libro : libros) {
        System.out.println("Libro encontrado: " + libro.getTitulo() +
        " - Editorial: " + libro.getEditorial().getNombre());
        }

        // Cerrar recursos
        // autorServicio.cerrarRecursos();
        libroServicio.cerrarRecursos();
        editorialServicio.cerrarRecursos();

    }
}