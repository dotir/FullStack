package com.egg.servicios;

import com.egg.entidades.Libro;
import com.egg.persistencias.LibroDAO;

import java.util.List;

public class LibroServicio {

    private final LibroDAO libroDAO;
    
    public LibroServicio() {
        this.libroDAO = new LibroDAO();
    }
    
    public Libro buscarLibroPorISBN(String isbn) {
        return libroDAO.buscarPorISBN(isbn);
    }

    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        return libroDAO.buscarPorTitulo(titulo);
    }

    public List<Libro> buscarLibrosPorEditorial(String nombreEditorial) {
        return libroDAO.buscarPorEditorial(nombreEditorial);
    }
    
    public void crearLibro(String titulo, String isbn, Integer anio, Integer ejemplares) {
        validarDatosLibro(titulo, isbn, anio, ejemplares);
        validarIsbnUnico(isbn);
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setIsbn(Long.parseLong(isbn));
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setAlta(true);
        libroDAO.guardar(libro);
    }

    private void validarDatosLibro(String titulo, String isbn, Integer anio, Integer ejemplares) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN es obligatorio");
        }
        if (anio == null || anio < 0) {
            throw new IllegalArgumentException("El año debe ser válido");
        }
        if (ejemplares == null || ejemplares < 0) {
            throw new IllegalArgumentException("La cantidad de ejemplares debe ser válida");
        }
    }
    
    private void validarIsbnUnico(String isbn) {
        try {
            Libro libroExistente = libroDAO.buscarPorISBN(isbn);
            if (libroExistente != null) {
                throw new IllegalArgumentException("Ya existe un libro con ese ISBN");
            }
        } catch (Exception e) {
            // Si no encuentra el libro, es correcto, podemos continuar
        }
    }
    
    public void cerrarRecursos() {
        libroDAO.cerrar();
    }
}
