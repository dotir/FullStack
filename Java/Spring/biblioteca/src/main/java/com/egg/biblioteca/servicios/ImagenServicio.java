package com.egg.biblioteca.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.repositorios.ImagenRepositorio;

@Service
public class ImagenServicio {

    @Autowired
    private ImagenRepositorio imagenRepositorio;
    
    public Imagen guardar(MultipartFile archivo) throws Exception {
        if(archivo != null) {
            try {
                Imagen imagen = new Imagen();
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public Imagen actualizar(String id, MultipartFile archivo) throws Exception {
        if(archivo != null) {
            try {
                Imagen imagen = imagenRepositorio.findById(id).orElse(null);
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());

                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    public byte[] obtenerImagen(String id) {
        Imagen imagen = imagenRepositorio.findById(id).orElse(null);
        return imagen != null ? imagen.getContenido() : null;
    }
}
