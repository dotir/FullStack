package com.egg.entidades;
import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;

    private int cantidad_en_stock;

    @Column(length = 255)
    private String codigo_producto;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 255)
    private String dimensiones;

    @Column(length = 255)
    private String nombre;

    private double precio_proveedor;
    private double precio_venta;

    @Column(length = 255)
    private String proveedor;

    @ManyToOne
    @JoinColumn(name = "id_gama")
    private GamaProducto gamaProducto;

    // Getters y setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_en_stock() {
        return cantidad_en_stock;
    }

    public void setCantidad_en_stock(int cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_proveedor() {
        return precio_proveedor;
    }

    public void setPrecio_proveedor(double precio_proveedor) {
        this.precio_proveedor = precio_proveedor;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public GamaProducto getGamaProducto() {
        return gamaProducto;
    }

    public void setGamaProducto(GamaProducto gamaProducto) {
        this.gamaProducto = gamaProducto;
    }
}
