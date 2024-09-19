package GestionProductos;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Producto> carritoDeCompras;
    private List<Producto> listaDeDeseos;

    public Cliente() {
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.carritoDeCompras = new ArrayList<>();
        this.listaDeDeseos = new ArrayList<>();
    }
    
    public void agregarAlCarrito(Producto producto) throws ProductoAgotadoException {
        if (producto.getCantidad() > 0) {
            carritoDeCompras.add(producto);
            producto.setCantidad(producto.getCantidad() - 1);
        } else {
            throw new ProductoAgotadoException(producto.getNombre() + " está agotado.");
        }
    }

    public void agregarAListaDeDeseos(Producto producto) {
        listaDeDeseos.add(producto);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getCarritoDeCompras() {
        return carritoDeCompras;
    }

    public List<Producto> getListaDeDeseos() {
        return listaDeDeseos;
    }

}
