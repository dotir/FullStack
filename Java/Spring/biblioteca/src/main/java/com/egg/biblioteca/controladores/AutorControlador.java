package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import com.egg.biblioteca.servicios.AutorServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.egg.biblioteca.excepciones.MiException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
}
