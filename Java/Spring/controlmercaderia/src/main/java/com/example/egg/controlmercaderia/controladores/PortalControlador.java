package com.example.egg.controlmercaderia.controladores;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.egg.controlmercaderia.entidades.Articulo;
import com.example.egg.controlmercaderia.servicios.ArticuloService;

@Controller
public class PortalControlador {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/portalusuario")
    public String mostrarPortalUsuario(Model model) {
        List<Articulo> articulos = articuloService.findAll();
        
        // Convert images to Base64 strings
        for (Articulo articulo : articulos) {
            if (articulo.getImagen() != null) {
                String base64Image = Base64.getEncoder().encodeToString(articulo.getImagen());
                articulo.setImagenString("data:image/jpeg;base64," + base64Image);
            }
        }
        
        model.addAttribute("articulos", articulos);
        return "portalusuario";
    }

    @GetMapping("/portaladmin")
    public String mostrarPortalAdmin() {
        return "portaladmin"; // Maps to portaladmin.html
    }
    
    @GetMapping("/")
    public String index() {
        return "redirect:/portalusuario"; // Default redirect for root path
    }
}
