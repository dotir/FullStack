package com.example.egg.controlmercaderia.controladores;

import java.io.IOException;
import java.util.Base64; // Import Base64
import java.util.List; // Import File

import org.springframework.beans.factory.annotation.Autowired; // Import IOException
import org.springframework.stereotype.Controller; // Import Path
import org.springframework.ui.Model; // Import Paths
import org.springframework.web.bind.annotation.GetMapping; // Import for Base64 utilities
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.egg.controlmercaderia.entidades.Articulo;
import com.example.egg.controlmercaderia.entidades.Fabrica; // Import Fábrica
import com.example.egg.controlmercaderia.servicios.ArticuloService;
import com.example.egg.controlmercaderia.servicios.FabricaService; // Import FabricaService

@Controller
@RequestMapping("/articulos")
public class ArticuloControlador {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private FabricaService fabricaService; // Autowire FabricaService

    @GetMapping
    public String listarArticulos(Model model) {
        try {
            List<Articulo> articulos = articuloService.findAll();
            // Decode images for display
            articulos.forEach(articulo -> {
                if (articulo.getImagen() != null) {
                    String base64Image = Base64.getEncoder().encodeToString(articulo.getImagen());
                    articulo.setImagenString("data:image/jpeg;base64," + base64Image);
                }
            });
            model.addAttribute("articulos", articulos);
            model.addAttribute("timestamp", System.currentTimeMillis()); // Add timestamp
            return "articulos/articulo_list"; // Referring to articulo_list.html
        } catch (Exception e) {
            // Log the exception (you can also implement a logging framework)
            System.err.println("Error fetching articles: " + e.getMessage());
            model.addAttribute("error", "Error fetching articles");
            return "articulos/articulo_list"; // Return the same view with error
        }
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        Articulo articulo = new Articulo();
        articulo.setFabrica(new Fabrica()); // Initialize the fabrica field to prevent null reference
        model.addAttribute("articulo", articulo);
        model.addAttribute("isEditing", false); // New attribute for inserting

        List<Fabrica> fabricas = fabricaService.findAll();
        model.addAttribute("fabricas", fabricas); // Add factories to model
        
        return "articulos/articulo_form"; // Referring to articulo_form.html
    }

    @GetMapping("/modificar")
    public String mostrarFormularioModificar(@RequestParam Integer nroArticulo, Model model) {
        Articulo articulo = articuloService.findByNroArticulo(nroArticulo)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
                
        // Add the article to the model
        model.addAttribute("articulo", articulo);
        model.addAttribute("isEditing", true);
        
        // Load and add the list of fábricas
        List<Fabrica> fabricas = fabricaService.findAll();
        model.addAttribute("fabricas", fabricas);
        
        return "articulos/articulo_form";
    }

    @GetMapping("/cliente") // New endpoint for client view
    public String mostrarArticulosCliente(Model model) {
        List<Articulo> articulos = articuloService.findAll();
        
        // Convert images to Base64 strings
        for (Articulo articulo : articulos) {
            if (articulo.getImagen() != null) {
                String base64Image = Base64.getEncoder().encodeToString(articulo.getImagen());
                articulo.setImagenString("data:image/jpeg;base64," + base64Image);// Set the base64 encoded image string
            }
        }
        
        model.addAttribute("articulos", articulos);
        return "articulos/articulo_cliente"; // Referring to articulo_cliente.html
    }

    @PostMapping
    public String crearArticulo(@RequestParam Integer nroArticulo, 
                                @RequestParam String nombreArticulo, 
                                @RequestParam String descripcionArticulo, 
                                @RequestParam String fabricaId,
                                @RequestParam("imagen") MultipartFile imagenFile, 
                                RedirectAttributes redirectAttributes) {
        Articulo articulo = new Articulo();
        articulo.setNroArticulo(nroArticulo);
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcionArticulo(descripcionArticulo);
        // Set fabrica
        Fabrica fabrica = fabricaService.findById(fabricaId)
                            .orElseThrow(() -> new RuntimeException("Fábrica no encontrada"));
        articulo.setFabrica(fabrica);
        // Convert uploaded image to byte array
        try {
            byte[] imageBytes = imagenFile.getBytes(); // Get bytes from the uploaded file
            articulo.setImagen(imageBytes); // Save the byte array in Articulo
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Error processing image.");
            return "redirect:/articulos/nuevo"; // Return to form in case of error
        }

        articuloService.save(articulo);
        redirectAttributes.addFlashAttribute("success", "Artículo creado exitosamente.");
        return "redirect:/articulos"; // Redirect to article list
    }

    @PostMapping("/modificar")
    public String actualizarArticulo(   @RequestParam Integer nroArticulo, 
                                        @RequestParam String nombreArticulo, 
                                        @RequestParam String descripcionArticulo, 
                                        @RequestParam String fabricaId,
                                        @RequestParam(value = "imagen", required = false) MultipartFile imagenFile, // Optional parameter
                                        RedirectAttributes redirectAttributes) {
        Articulo articulo = articuloService.findByNroArticulo(nroArticulo)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
        
        articulo.setNombreArticulo(nombreArticulo);
        articulo.setDescripcionArticulo(descripcionArticulo);
        articulo.setFabrica(fabricaService.findById(fabricaId)
                .orElseThrow(() -> new RuntimeException("Fábrica no encontrada"))); // Set the factory

        if (imagenFile != null && !imagenFile.isEmpty()) {
            try {
                // Save the uploaded image if a new file is provided
                byte[] imageBytes = imagenFile.getBytes(); // Get bytes from the uploaded file
                articulo.setImagen(imageBytes); // Save the byte array in Articulo
            } catch (IOException e) {
                redirectAttributes.addFlashAttribute("error", "Error processing image.");
                return "redirect:/articulos/modificar?nroArticulo=" + nroArticulo; // Return to the edit form
            }
        }
        
        articuloService.save(articulo);
        redirectAttributes.addFlashAttribute("success", "Artículo actualizado exitosamente.");
        return "redirect:/articulos"; // Redirect to article list
    }

    // ArticuloControlador.java - Add new endpoint
    @GetMapping("/eliminar")
    public String eliminarArticulo(@RequestParam Integer nroArticulo, RedirectAttributes redirectAttributes) {
        try {
            Articulo articulo = articuloService.findByNroArticulo(nroArticulo)
                    .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));
            
            articuloService.delete(articulo);
            redirectAttributes.addFlashAttribute("success", "Artículo eliminado exitosamente");
            
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el artículo: " + e.getMessage());
        }
        return "redirect:/articulos";
    }
}
