package com.example.egg.controlmercaderia.entidades;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient; // Import for Lob
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articulo {

    @Id
    @UuidGenerator
    @Column(columnDefinition = "VARCHAR(36)")
    private String idArticulo;

    @Column(unique = true, nullable = false)
    private Integer nroArticulo;

    @Column(nullable = false)
    private String nombreArticulo;

    @Column(nullable = false)
    private String descripcionArticulo;

    @ManyToOne(optional = false)
    private Fabrica fabrica;

    @Lob // Indicate that this can store large data
    private byte[] imagen; // Store the image as byte array

    @Transient // Not to be persisted in the database
    private String imagenString; // For holding the Base64 string
   
    // Getter and Setter for imagenString
    public String getImagenString() {
        return imagenString;
    }
    
    public void setImagenString(String imagenString) {
        this.imagenString = imagenString;
    }
}
