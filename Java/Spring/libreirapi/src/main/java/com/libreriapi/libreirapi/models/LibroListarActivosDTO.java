package com.libreriapi.libreirapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibroListarActivosDTO {
    private String titulo;
    private Integer ejemplares;
}
