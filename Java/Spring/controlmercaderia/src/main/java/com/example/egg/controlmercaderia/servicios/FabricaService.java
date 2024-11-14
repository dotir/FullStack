package com.example.egg.controlmercaderia.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egg.controlmercaderia.entidades.Fabrica;
import com.example.egg.controlmercaderia.repositorios.FabricaRepository;

import java.util.List;

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

}
