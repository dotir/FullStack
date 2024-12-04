package com.libreriapi.libreirapi.models;

import lombok.Data;

@Data
public class LibroCreateDTO {
    private Long isbn;//Este dato sera utilizado como idLibro
    private String titulo;
    private Integer ejemplares;
    private Long idAutor;
    private Long idEditorial;
    private boolean libroActivo;
}
