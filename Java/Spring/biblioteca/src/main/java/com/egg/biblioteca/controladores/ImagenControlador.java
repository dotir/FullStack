package com.egg.biblioteca.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;

import com.egg.biblioteca.servicios.ImagenServicio;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    @Autowired
    private ImagenServicio imagenServicio;

    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable String id) {
        try {
            if (id != null) {
                // Obtener imagen desde el servicio
                byte[] imagen = imagenServicio.obtenerImagen(id);

                // Configurar headers de la respuesta
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG);

                // Retornar la imagen en la respuesta
                return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
