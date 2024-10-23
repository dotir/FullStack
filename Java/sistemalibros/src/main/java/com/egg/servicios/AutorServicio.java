package com.egg.servicios;

import com.egg.entidades.Autor;
import com.egg.persistencias.AutorDAO;

import java.util.List;

public class AutorServicio {

    private final AutorDAO autorDAO;
    
    public AutorServicio() {
        this.autorDAO = new AutorDAO();
    }
    
    public List<Autor> buscarAutoresPorNombre(String nombre) {
        return autorDAO.buscarPorNombre(nombre);
    }
    
    public void crearAutor(String nombre) {
        validarDatosAutor(nombre);
        validarNombreUnico(nombre);
        
        Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setAlta(true);
        autorDAO.guardar(autor);
    }

    private void validarDatosAutor(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor es obligatorio");
        }
    }
    
    private void validarNombreUnico(String nombre) {
        if (autorDAO.existeAutorPorNombre(nombre)) {
            throw new IllegalArgumentException("Ya existe un autor con ese nombre");
        }
    }
    
    public void cerrarRecursos() {
        autorDAO.cerrar();
    }
}
