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
import com.example.egg.controlmercaderia.enumeraciones.Rol;
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
    public String mostrarFormularioModificar(@RequestParam String username, Model model, RedirectAttributes redirectAttributes) {
        Usuario usuario = usuarioService.findByUsername(username)
                .orElse(null);
        if (usuario == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado.");
            return "redirect:/usuarios"; // Redirect to user list with error message
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("isEditing", true); // New attribute for editing
        return "usuarios/usuario_form"; // Referring to usuario_form.html
    }

    @PostMapping
    public String crearUsuario(@RequestParam String username, 
                               @RequestParam String password, // Added password parameter
                               @RequestParam String confirmPassword, // Added confirmation password parameter
                               @RequestParam String nombre, 
                               @RequestParam String apellido, 
                               Model model) { // Change RedirectAttributes to Model
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Las contraseñas no coinciden.");
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            model.addAttribute("usuario", usuario); // Add the input to keep them on error
            return "usuarios/usuario_form"; // Return to the form view with error message
        }
        if (usuarioService.findByUsername(username).isPresent()) {
            model.addAttribute("error", "El usuario ya existe.");
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            model.addAttribute("usuario", usuario); // Add the input to keep them on error
            return "usuarios/usuario_form"; // Return to the form view with error message
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password); // Set the password
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuarioService.save(usuario); // Password will be hashed in the save method
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

    @GetMapping("/eliminar")
    public String eliminarUsuario(@RequestParam String username, RedirectAttributes redirectAttributes) {
        try {
            Usuario usuario = usuarioService.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            
            // Don't allow deleting the last admin
            if (usuario.getRol() == Rol.ADMIN && usuarioService.countAdminUsers() <= 1) {
                redirectAttributes.addFlashAttribute("error", "No se puede eliminar el último administrador");
                return "redirect:/usuarios";
            }

            usuarioService.deleteByUsername(username);
            redirectAttributes.addFlashAttribute("success", "Usuario eliminado exitosamente");
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el usuario: " + e.getMessage());
        }
        return "redirect:/usuarios";
    }
}
