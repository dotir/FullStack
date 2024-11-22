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

import com.example.egg.controlmercaderia.entidades.Fabrica;
import com.example.egg.controlmercaderia.servicios.ArticuloService;
import com.example.egg.controlmercaderia.servicios.FabricaService;

@Controller
@RequestMapping("/fabricas")
public class FabricaControlador {

    @Autowired
    private FabricaService fabricaService;

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public String listarFabricas(Model model) {
        List<Fabrica> fabricas = fabricaService.findAll();
        model.addAttribute("fabricas", fabricas);
        return "fabricas/fabrica_list"; // Referring to fabrica_list.html
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("fabrica", new Fabrica());
        model.addAttribute("isEditing", false); // New attribute for inserting
        return "fabricas/fabrica_form"; // Referring to fabrica_form.html
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam String idFabrica, Model model) {
        Fabrica fabrica = fabricaService.findById(idFabrica)
                .orElseThrow(() -> new RuntimeException("Fábrica no encontrada"));
        model.addAttribute("fabrica", fabrica);
        model.addAttribute("isEditing", true); // New attribute for editing
        return "fabricas/fabrica_form"; // Referring to fabrica_form.html
    }

    @PostMapping
    public String crearFabrica(@RequestParam String nombreFabrica, 
                                RedirectAttributes redirectAttributes) {
        Fabrica fabrica = new Fabrica();
        fabrica.setNombreFabrica(nombreFabrica);
        fabricaService.save(fabrica);
        redirectAttributes.addFlashAttribute("success", "Fábrica creada exitosamente.");
        return "redirect:/fabricas"; // Redirect to factory list
    }

    @PostMapping("/modificar")
    public String actualizarFabrica(@RequestParam String idFabrica, 
                                     @RequestParam String nombreFabrica,
                                     RedirectAttributes redirectAttributes) {
        Fabrica fabrica = fabricaService.findById(idFabrica)
                .orElseThrow(() -> new RuntimeException("Fábrica no encontrada"));
        
        fabrica.setNombreFabrica(nombreFabrica);
        fabricaService.save(fabrica);
        redirectAttributes.addFlashAttribute("success", "Fábrica actualizada exitosamente.");
        return "redirect:/fabricas"; // Redirect to factory list
    }

    @GetMapping("/eliminar")
    public String eliminarFabrica(@RequestParam String idFabrica, RedirectAttributes redirectAttributes) {
        try {
            Fabrica fabrica = fabricaService.findById(idFabrica)
                    .orElseThrow(() -> new RuntimeException("Fábrica no encontrada"));
                
            // Check if factory has articles before deleting
            if (articuloService.existsByFabricaId(idFabrica)) {
                redirectAttributes.addFlashAttribute("error", 
                    "No se puede eliminar la fábrica porque tiene artículos asociados");
                return "redirect:/fabricas";
            }
                
            fabricaService.delete(fabrica);
            redirectAttributes.addFlashAttribute("success", "Fábrica eliminada exitosamente");
                
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la fábrica: " + e.getMessage());
        }
        return "redirect:/fabricas";
    }
}
