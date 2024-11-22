package com.example.egg.controlmercaderia.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.egg.controlmercaderia.entidades.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, String> {
    Optional<Articulo> findByNroArticulo(Integer nroArticulo);
    boolean existsByFabricaIdFabrica(String fabricaId);
}
