package com.example.egg.controlmercaderia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.egg.controlmercaderia.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
