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

import com.example.egg.controlmercaderia.entidades.Articulo;
import com.example.egg.controlmercaderia.servicios.ArticuloService;

@Controller
@RequestMapping("/articulos")
public class ArticuloControlador {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public String listarArticulos(Model model) {
        List<Articulo> articulos = articuloService.findAll();
        model.addAttribute("articulos", articulos);
        return "articulos/articulo_list"; // Referring to articulo_list.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("articulo", new Articulo());
        model.addAttribute("isEditing", false); // New attribute for inserting
        return "articulos/articulo_form"; // Referring to articulo_form.html
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam Integer nroArticulo, Model model) {
        Articulo articulo = articuloService.findByNroArticulo(nroArticulo)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        model.addAttribute("articulo", articulo);
        model.addAttribute("isEditing", true); // New attribute for editing
        return "articulos/articulo_form"; // Referring to articulo_form.html
    }

    @PostMapping
    public String crearArticulo(@RequestParam Integer nroArticulo, 
                                @RequestParam String nombreArticulo, 
                                @RequestParam String descripcionArticulo, 
                                RedirectAttributes redirectAttributes) {
        Articulo articulo = new Articulo();
        articulo.setNroArticulo(nroArticulo);
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcionArticulo(descripcionArticulo);
        articuloService.save(articulo);
        redirectAttributes.addFlashAttribute("success", "Artículo creado exitosamente.");
        return "redirect:/articulos"; // Redirect to article list
    }

    @PostMapping("/modificar")
    public String actualizarArticulo(@RequestParam Integer nroArticulo, 
                                      @RequestParam String nombreArticulo, 
                                      @RequestParam String descripcionArticulo, 
                                      RedirectAttributes redirectAttributes) {
        Articulo articulo = articuloService.findByNroArticulo(nroArticulo)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcionArticulo(descripcionArticulo);
        articuloService.save(articulo);
        redirectAttributes.addFlashAttribute("success", "Artículo actualizado exitosamente.");
        return "redirect:/articulos"; // Redirect to article list
    }
}
