package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    //metodo buscar por email
    public Usuario findByEmail(String email);
    
}
