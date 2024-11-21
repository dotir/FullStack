package com.example.egg.controlmercaderia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.egg.controlmercaderia.entidades.Usuario;
import com.example.egg.controlmercaderia.enumeraciones.Rol;
import com.example.egg.controlmercaderia.servicios.UsuarioService;

@Controller
public class LoginControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String login() {
        return "login"; // Change to your login view name
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro"; // Will create this template
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String confirmPassword,
                                 @RequestParam String nombre,
                                 @RequestParam String apellido,
                                 RedirectAttributes redirectAttributes) {
        
        if (!password.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
            return "redirect:/registro";
        }

        if (usuarioService.findByUsername(username).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "El nombre de usuario ya existe");
            return "redirect:/registro";
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setRol(Rol.USER);

        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("success", "Usuario registrado exitosamente");
        return "redirect:/login";
    }
}
