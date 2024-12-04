package com.libreriapi.libreirapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreriapi.libreirapi.entities.Editorial;
import com.libreriapi.libreirapi.models.EditorialCreateDTO;
import com.libreriapi.libreirapi.models.EditorialDetailsDTO;
import com.libreriapi.libreirapi.services.EditorialService;

@RestController
@RequestMapping("/editorial")
public class EditorialController {

    @Autowired
    private EditorialService editorialServicio;

    //usa el DTO
    @PostMapping("crear")
    public ResponseEntity<Object> crearEditorial(EditorialCreateDTO editorialCreateDTO) {
        try {
            editorialServicio.createEditorial(editorialCreateDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //listar
    @GetMapping("listar")
    public ResponseEntity<Object> listarEditoriales() {
        try {
            return new ResponseEntity<>(editorialServicio.getAllEditorials(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Object> deleteEditorial(@PathVariable Long id) {
        try {
            editorialServicio.deleteEditorial(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listarEditorial/{id}")
    public ResponseEntity<EditorialDetailsDTO> listarEditorial(@PathVariable Long id) {
    try {
        Editorial editorial = editorialServicio.getOne(id);
        EditorialDetailsDTO dto = new EditorialDetailsDTO(editorial);
        return ResponseEntity.ok(dto);
    } catch (RuntimeException e) {
        return ResponseEntity.notFound().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
}
