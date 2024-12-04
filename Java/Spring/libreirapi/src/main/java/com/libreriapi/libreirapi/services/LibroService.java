package com.libreriapi.libreirapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libreriapi.libreirapi.entities.Autor;
import com.libreriapi.libreirapi.entities.Editorial;
import com.libreriapi.libreirapi.entities.Libro;
import com.libreriapi.libreirapi.models.LibroCreateDTO;
import com.libreriapi.libreirapi.models.LibroListarActivosDTO;
import com.libreriapi.libreirapi.repositories.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorService autorServicio;

    @Autowired
    private EditorialService editorialServicio;

    @Transactional
    public void crearLibro(LibroCreateDTO libroCreateDTO) {
        Libro libroNvo = new Libro();
        libroNvo.setIdLibro(libroCreateDTO.getIsbn());
        libroNvo.setTitulo(libroCreateDTO.getTitulo());
        libroNvo.setEjemplares(libroCreateDTO.getEjemplares());
        libroNvo.setLibroActivo(libroCreateDTO.isLibroActivo());
        Autor autor = autorServicio.getAutorById(libroCreateDTO.getIdAutor()).orElse(null);
        if (autor != null) {
            libroNvo.setAutor(autor);
        }
        Editorial editorial = editorialServicio.getEditorialById(libroCreateDTO.getIdEditorial()).orElse(null);
        if (editorial != null) {
            libroNvo.setEditorial(editorial);
        }
        libroRepository.save(libroNvo);
    }

    public List<LibroListarActivosDTO> listarLibrosActivos() {
        return libroRepository.encontrarActivos();
    }

    public List<LibroListarActivosDTO> getLibrosByEditorial(Long editorialId) {
        return libroRepository.findByEditorialId(editorialId);
    }

    public List<LibroListarActivosDTO> getLibrosByAutor(Long autorId) {
        return libroRepository.findByAutorId(autorId);
    }

    public List<LibroListarActivosDTO> getLibrosByAutorAndEditorial(Long autorId, Long editorialId) {
        return libroRepository.findByAutorIdAndEditorialId(autorId, editorialId);
    }
}
