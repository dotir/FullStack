package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validar(nombre);
        Autor autor = new Autor();// Instancio un objeto del tipo Autor
        autor.setNombre(nombre);// Seteo el atributo, con el valor recibido como parámetro

        autorRepositorio.save(autor); // Persisto el dato en mi BBDD
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutores() {

        List<Autor> autores = new ArrayList<Autor>();

        autores = autorRepositorio.findAll();

        return autores;
    }

    @Transactional
    public void modificarAutor(String nombre, String id) throws MiException {
        validar(nombre);
        Optional<Autor> respuesta = autorRepositorio.findById(UUID.fromString(id));
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();

            autor.setNombre(nombre);
            autorRepositorio.save(autor);
        }
    }

    // metodo validar si el nombre no esta vacio ni es nulo
    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
    }

     @Transactional(readOnly = true)
    public Autor  getOne(String id){
        return autorRepositorio.getReferenceById(UUID.fromString(id));
    }


}