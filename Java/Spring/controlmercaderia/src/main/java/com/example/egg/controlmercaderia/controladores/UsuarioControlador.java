package com.example.egg.controlmercaderia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.egg.controlmercaderia.entidades.Usuario;
import com.example.egg.controlmercaderia.servicios.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/usuario_list"; // Referring to usuario_list.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("isEditing", false); // New attribute for inserting
        return "usuarios/usuario_form"; // Referring to usuario_form.html
    }
    
    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam String username, Model model) {
        Usuario usuario = usuarioService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        model.addAttribute("usuario", usuario);
        model.addAttribute("isEditing", true); // New attribute for editing
        return "usuarios/usuario_form"; // Referring to usuario_form.html
    }

    @PostMapping
    public String crearUsuario(@RequestParam String username, 
                               @RequestParam String nombre, 
                               @RequestParam String apellido, 
                               RedirectAttributes redirectAttributes) {
        if (usuarioService.findByUsername(username).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "El usuario ya existe.");
            return "redirect:/usuarios/nuevo"; // Redirect to new user form with error message
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("success", "Usuario creado exitosamente.");
        return "redirect:/usuarios"; // Redirect to user list
    }

    @PostMapping("/modificar")
    public String actualizarUsuario(@RequestParam String username, 
                                    @RequestParam String nombre, 
                                    @RequestParam String apellido, 
                                    RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("success", "Usuario actualizado exitosamente.");
        return "redirect:/usuarios"; // Redirect to user list
    }
}