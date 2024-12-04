package com.libreriapi.libreirapi.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.libreriapi.libreirapi.entities.Autor;
import com.libreriapi.libreirapi.repositories.AutorRepository;


@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor createAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public List<Autor> getAllAutors() {
        return autorRepository.findAll();
    }

    public Optional<Autor> getAutorById(Long id) {
        return autorRepository.findById(id);
        }

    @Transactional
    public void updateAutor(String nombre,boolean activo, Long id) {
        Optional<Autor> respuesta = autorRepository.findById(id);
        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            System.out.println(autor);
            autor.setNombreAutor(nombre);
            autor.setAutorActivo(activo);
            autorRepository.save(autor);
        }else {
            throw new NoSuchElementException("No se encontró el autor con ID: " + id);
        }
    }

        public void darBajaAutor(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("No se encontró el autor con id: " + id);
        }
        Autor autor = autorRepository.findById(id).orElseThrow();
        autor.setAutorActivo(false);
        autorRepository.save(autor);
    }
}
