package com.egg.servicios;

import com.egg.entidades.Editorial;
import com.egg.persistencias.EditorialDAO;

public class EditorialServicio {
    private final EditorialDAO editorialDAO;
    
    public EditorialServicio() {
        this.editorialDAO = new EditorialDAO();
    }
    
    public void crearEditorial(String nombre) {
        validarDatosEditorial(nombre);
        validarNombreUnico(nombre);
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorial.setAlta(true);
        editorialDAO.guardar(editorial);
    }

    private void validarDatosEditorial(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la editorial es obligatorio");
        }
    }
    
    private void validarNombreUnico(String nombre) {
        if (editorialDAO.existeEditorialPorNombre(nombre)) {
            throw new IllegalArgumentException("Ya existe una editorial con ese nombre");
        }
    }
    
    public void cerrarRecursos() {
        editorialDAO.cerrar();
    }
}
