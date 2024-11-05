package com.egg.biblioteca.repositorios;

import org.springframework.stereotype.Repository;
import com.egg.biblioteca.entidades.Libro;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {
    
    //buscar libro por titulo
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro findByTitulo(@Param("titulo") String titulo);

    //buscar libro por autor
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public Libro findByAutor(@Param("nombre") String nombre);
}
