package com.example.egg.controlmercaderia.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.egg.controlmercaderia.entidades.Usuario;
import com.example.egg.controlmercaderia.enumeraciones.Rol;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
    long countByRol(Rol rol);
}
