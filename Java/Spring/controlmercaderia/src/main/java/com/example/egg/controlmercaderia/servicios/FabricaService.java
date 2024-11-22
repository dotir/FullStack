package com.example.egg.controlmercaderia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egg.controlmercaderia.entidades.Fabrica;
import com.example.egg.controlmercaderia.repositorios.FabricaRepository;

@Service
public class FabricaService {

    @Autowired
    private FabricaRepository fabricaRepository;

    public List<Fabrica> findAll() {
        return fabricaRepository.findAll();
    }

    public Fabrica save(Fabrica fabrica) {
        return fabricaRepository.save(fabrica);
    }

    public Optional<Fabrica> findById(String id) {
        return fabricaRepository.findById(id);
    }

    public void delete(Fabrica fabrica) {
        fabricaRepository.delete(fabrica);
    }
}
