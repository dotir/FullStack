package com.egg.biblioteca.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.entidades.Editorial;
import org.springframework.transaction.annotation.Transactional;

import com.egg.biblioteca.excepciones.MiException;

@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        validar(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        
        editorialRepositorio.save(editorial);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList<Editorial>();

        editoriales = editorialRepositorio.findAll();
        
        return editoriales;
    }

    @Transactional
    public void modificarEditorial(String nombre, String id) throws MiException {
        validar(nombre);
        Editorial editorial = editorialRepositorio.findById(UUID.fromString(id)).orElse(null);
        if (editorial != null) {
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }
    }

    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede ser nulo o estar vacío");
        }
    }
    
}
