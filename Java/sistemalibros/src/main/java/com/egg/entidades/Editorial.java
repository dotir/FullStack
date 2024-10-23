package com.egg.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private Boolean alta;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libros;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
