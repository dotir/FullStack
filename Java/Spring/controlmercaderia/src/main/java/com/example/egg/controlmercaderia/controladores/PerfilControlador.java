package com.example.egg.controlmercaderia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.egg.controlmercaderia.entidades.Usuario;
import com.example.egg.controlmercaderia.servicios.UsuarioService;

@Controller
public class PerfilControlador {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/perfil")
    public String mostrarPerfil(Authentication authentication, Model model) {
        String username = authentication.getName();
        Usuario usuario = usuarioService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @PostMapping("/perfil")
    public String actualizarPerfil(@RequestParam String nombre,
                                  @RequestParam String apellido,
                                  @RequestParam(required = false) String password,
                                  @RequestParam(required = false) String confirmPassword,
                                  Authentication authentication,
                                  RedirectAttributes redirectAttributes) {
        String username = authentication.getName();
        Usuario usuario = usuarioService.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (password != null && !password.isEmpty()) {
            if (!password.equals(confirmPassword)) {
                redirectAttributes.addFlashAttribute("error", "Las contraseñas no coinciden");
                return "redirect:/perfil";
            }
            usuario.setPassword(password);
        }

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuarioService.save(usuario);
        redirectAttributes.addFlashAttribute("success", "Perfil actualizado exitosamente");
        return "redirect:/perfil";
    }
}
