package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;

import org.springframework.transaction.annotation.Transactional;
import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, Long idAutor, Long idEditorial) throws MiException {

        validar(titulo, titulo, idAutor, idEditorial);
        // Buscar Autor y Editorial usando los repositorios
        Autor autor = autorRepositorio.findById(idAutor).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Editorial editorial = editorialRepositorio.findById(idEditorial)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        // Crear una instancia de Libro y setear sus atributos
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro);
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {


        List<Libro> libros = new ArrayList<Libro>();


        libros = libroRepositorio.findAll();
        return libros;
    }

    @Transactional
    public void modificarLibro(String titulo, Date alta, Integer ejemplares, Long idAutor, Long idEditorial, Long id) throws MiException {

        validar(titulo, titulo, idAutor, idEditorial);
        // Buscar Autor y Editorial usando los repositorios
        Autor autor = autorRepositorio.findById(idAutor).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Editorial editorial = editorialRepositorio.findById(idEditorial)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        // Buscar el libro a modificar
        Libro libro = libroRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        // Setear los nuevos valores
        libro.setTitulo(titulo);
        libro.setAlta(alta);
        libro.setEjemplares(ejemplares);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        // Guardar los cambios
        libroRepositorio.save(libro);
    }


    // metodo validar si no esta vacio ni es nulo
    private void validar(String nombre, String apellido, Long idAutor , Long idEditorial) throws MiException{
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede ser nulo o estar vacío");
        }
        if (apellido.isEmpty() || apellido == null) {
            throw new MiException("El apellido no puede ser nulo o estar vacío");
        }
        if (idAutor == null) {
            throw new MiException("El idAutor no puede ser nulo");
        }
        if (idEditorial == null) {
            throw new MiException("El idEditorial no puede ser nulo");
        }
    }

    

}
