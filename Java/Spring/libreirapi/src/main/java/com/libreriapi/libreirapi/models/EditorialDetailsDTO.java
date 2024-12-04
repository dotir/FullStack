package com.libreriapi.libreirapi.models;

import com.libreriapi.libreirapi.entities.Editorial;

import lombok.Data;

@Data
public class EditorialDetailsDTO {
    private Long idEditorial;
    private boolean editorialActiva;
    private String nombreEditorial;
    
    public EditorialDetailsDTO(Editorial editorial) {
        this.idEditorial = editorial.getIdEditorial();
        this.editorialActiva = editorial.isEditorialActiva();
        this.nombreEditorial = editorial.getNombreEditorial();
    }
}