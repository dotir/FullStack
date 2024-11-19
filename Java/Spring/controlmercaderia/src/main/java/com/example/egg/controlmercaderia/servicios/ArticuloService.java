package com.example.egg.controlmercaderia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egg.controlmercaderia.entidades.Articulo;
import com.example.egg.controlmercaderia.repositorios.ArticuloRepository;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public List<Articulo> findAll() {
        return articuloRepository.findAll();
    }

    public Articulo save(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    public Optional<Articulo> findByNroArticulo(Integer nroArticulo) {
        return articuloRepository.findByNroArticulo(nroArticulo);
    }
}
