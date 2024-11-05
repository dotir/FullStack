package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.excepciones.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;

import java.util.List;

@Controller
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private AutorServicio autorServicio;

    @Autowired
    private EditorialServicio editorialServicio;

    @GetMapping("/registrar") // localhost:8080/libro/registrar
    public String registrar(ModelMap model) {
        List<Autor> autores = autorServicio.listarAutores();
        List<Editorial> editoriales = editorialServicio.listarEditoriales();
        model.addAttribute("autores", autores);
        model.addAttribute("editoriales", editoriales);
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro( @RequestParam(required = false) Long isbn, 
                            @RequestParam String titulo,
                            @RequestParam(required = false) Integer ejemplares, 
                            @RequestParam String idAutor,
                            @RequestParam String idEditorial,
                            ModelMap model) throws MiException {
        try {
            
            libroServicio.crearLibro(   isbn,
                                        titulo, 
                                        ejemplares, 
                                        idAutor, 
                                        idEditorial);
            model.put("exito", "Libro creado con éxito");

        } catch (MiException ex) {
            model.put("error", ex.getMessage());
            List<Autor> autores = autorServicio.listarAutores();
            List<Editorial> editoriales = editorialServicio.listarEditoriales();
            model.addAttribute("autores", autores);
            model.addAttribute("editoriales", editoriales);

            return "libro_form.html"; // volvemos a cargar el formulario.
        }

        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {


        List<Libro> libros = libroServicio.listarLibros();
        modelo.addAttribute("libros", libros);
        return "libro_list.html";
    }

}
