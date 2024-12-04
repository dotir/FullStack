package com.libreriapi.libreirapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.libreriapi.libreirapi.models.LibroCreateDTO;
import com.libreriapi.libreirapi.services.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroServicio;

    @PostMapping("/crear")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCreateDTO libroDTO) {
        try {
            libroServicio.crearLibro(libroDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"Algun dato no es correcto o es nulo, revisar.\"}");
        }
    }

    //listar libros activos
    @GetMapping("/listar")
    public ResponseEntity<Object> listarLibrosActivos() {
        try {
            return new ResponseEntity<>(libroServicio.listarLibrosActivos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/editorial/{editorialId}")
    public ResponseEntity<Object> getLibrosByEditorial(@PathVariable Long editorialId) {
        try {
            return new ResponseEntity<>(libroServicio.getLibrosByEditorial(editorialId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/autor/{autorId}")
    public ResponseEntity<Object> getLibrosByAutor(@PathVariable Long autorId) {
        try {
            return new ResponseEntity<>(libroServicio.getLibrosByAutor(autorId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listar/autor/editorial")
    public ResponseEntity<Object> getLibrosByAutorYEditorial(@RequestParam Long autorId, @RequestParam Long editorialId) {
        try {
            return new ResponseEntity<>(libroServicio.getLibrosByAutorAndEditorial(autorId, editorialId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
