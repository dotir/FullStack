package com.libreriapi.libreirapi.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @Column(nullable = false, length = 13) // Assuming ISBN-13
    private Long idLibro;

    @Column(nullable = false)
    private int ejemplares;

    @Column(nullable = false)
    private boolean libroActivo;

    @Column(nullable = false, length = 255)
    private String titulo;

    @ManyToOne
    private Autor autor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_editorial", nullable = false)
    private Editorial editorial;
}
