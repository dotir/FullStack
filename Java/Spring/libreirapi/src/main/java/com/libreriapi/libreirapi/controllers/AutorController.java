package com.libreriapi.libreirapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriapi.libreirapi.entities.Autor;
import com.libreriapi.libreirapi.models.AutorUpdateDTO;
import com.libreriapi.libreirapi.services.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService autorServicio;

    @PostMapping("crear")
    public ResponseEntity<Object> crearAutor(String nombre) {
        try {
            Autor nuevoAutor = new Autor();
            nuevoAutor.setNombreAutor(nombre);
            nuevoAutor.setAutorActivo(true);

            autorServicio.createAutor(nuevoAutor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("listar")
    public ResponseEntity<Object> listarAutores() {
        try {
            return new ResponseEntity<>(autorServicio.getAllAutors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/modificar")
    public ResponseEntity<Void> modificarAutor(@RequestBody AutorUpdateDTO autorUpdateDTO, @RequestParam Long id) {
        try {
            // Updating the author's name
            autorServicio.updateAutor(autorUpdateDTO.getNombreAutor(), autorUpdateDTO.isAutorActivo(), id);
            
            // If the author is not active, call darBajaAutor
            if (!autorUpdateDTO.isAutorActivo()) {
                autorServicio.darBajaAutor(id);
            }
            
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
