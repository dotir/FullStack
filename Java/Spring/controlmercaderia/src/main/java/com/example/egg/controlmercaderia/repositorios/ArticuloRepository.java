package com.example.egg.controlmercaderia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.egg.controlmercaderia.entidades.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, String> {

}
