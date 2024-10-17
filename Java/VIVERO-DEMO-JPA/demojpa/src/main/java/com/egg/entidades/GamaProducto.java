package com.egg.entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "gama_producto")
public class GamaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_gama;

    @Column(length = 255)
    private String descripcion_html;

    @Column(length = 255)
    private String descripcion_texto;

    @Column(length = 255)
    private String gama;

    @Column(length = 255)
    private String imagen;

    // Getters y setters
    public int getId_gama() {
        return id_gama;
    }

    public void setId_gama(int id_gama) {
        this.id_gama = id_gama;
    }

    public String getDescripcion_html() {
        return descripcion_html;
    }

    public void setDescripcion_html(String descripcion_html) {
        this.descripcion_html = descripcion_html;
    }

    public String getDescripcion_texto() {
        return descripcion_texto;
    }

    public void setDescripcion_texto(String descripcion_texto) {
        this.descripcion_texto = descripcion_texto;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
