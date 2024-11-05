package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import com.egg.biblioteca.servicios.AutorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.excepciones.MiException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

@Controller
@RequestMapping("/autor")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;
    
    @RequestMapping("/registrar")
    public String registrar(){
        return "autor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) throws MiException {
        try {
            autorServicio.crearAutor(nombre);    // llamo a mi servicio para persistir     
            modelo.addAttribute("exito", "Autor registrado");   
        } catch (MiException ex) {        
            modelo.addAttribute("error", ex.getMessage());  
            Logger.getLogger(AutorControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "autor_form.html";
        }     
        
        return "index.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {
        modelo.put("autor", autorServicio.getOne(id));

        return "autor_modificar.html";
    }


    @PostMapping("{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo) {
        try {
            autorServicio.modificarAutor(nombre, id);
            return "redirect:/autor/lista";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "autor_modificar.html";
        }
    }


    @GetMapping("/lista")
    public String listar(ModelMap modelo) {


        List<Autor> autores = autorServicio.listarAutores();
        modelo.addAttribute("autores", autores);
        return "autor_list.html";
    }
}
