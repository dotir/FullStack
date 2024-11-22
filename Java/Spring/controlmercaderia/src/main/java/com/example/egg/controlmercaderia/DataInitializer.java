package com.example.egg.controlmercaderia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.egg.controlmercaderia.entidades.Usuario;
import com.example.egg.controlmercaderia.enumeraciones.Rol;
import com.example.egg.controlmercaderia.servicios.UsuarioService;

import jakarta.annotation.PostConstruct;

@Service
public class DataInitializer {

    @Autowired
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        // Check if admin user exists
        if (usuarioService.findByUsername("admin").isEmpty()) {
            // Create admin user
            Usuario adminUser = new Usuario();
            adminUser.setUsername("admin");
            adminUser.setPassword("123456");
            adminUser.setNombre("Admin");
            adminUser.setApellido("Admin");
            adminUser.setRol(Rol.ADMIN);
            
            usuarioService.save(adminUser);
            System.out.println("Admin user created successfully");
        }
    }
}
