package com.egg.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email,
            @RequestParam String password,
            @RequestParam String password2, ModelMap modelo) {
        try {
            usuarioServicio.registrar(nombre, email, password, password2);
            modelo.put("exito", "Usuario registrado con éxito");

            return "index";

        } catch (MiException e) {
            modelo.put("error", e.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);
            modelo.put("password", password);
            modelo.put("password2", password2);
            return "registro";
        }

    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            modelo.put("error", "Usuario o Contraseña inválidos!");
        }
        return "login";
    }

    //metodo inicio
    @GetMapping("/inicio")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String inicio() {
        return "inicio.html";
    }

}