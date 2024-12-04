package com.libreriapi.libreirapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.libreriapi.libreirapi.entities.Libro;
import com.libreriapi.libreirapi.models.LibroListarActivosDTO;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    // Directly retrieve the required information by creating an instance of LibroListarActivosDTO
    @Query("SELECT new com.libreriapi.libreirapi.models.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.libroActivo = true")
    List<LibroListarActivosDTO> encontrarActivos();

    @Query("SELECT new com.libreriapi.libreirapi.models.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.editorial.id = :editorialId AND l.libroActivo = true")
    List<LibroListarActivosDTO> findByEditorialId(Long editorialId);

    @Query("SELECT new com.libreriapi.libreirapi.models.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.autor.id = :autorId AND l.libroActivo = true")
    List<LibroListarActivosDTO> findByAutorId(Long autorId);

    @Query("SELECT new com.libreriapi.libreirapi.models.LibroListarActivosDTO(l.titulo, l.ejemplares) " +
            "FROM Libro l WHERE l.autor.id = :autorId AND l.editorial.id = :editorialId AND l.libroActivo = true")
    List<LibroListarActivosDTO> findByAutorIdAndEditorialId(Long autorId, Long editorialId);
}
