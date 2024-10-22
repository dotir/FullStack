package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Producto;
import com.egg.persistencia.ProductoDAO;

public class ProductoServicio {

    private final ProductoDAO daoProducto;

    public ProductoServicio() {
        this.daoProducto = new ProductoDAO();
    }

    public void crearProducto(String nombre, String descripcion, double precio, int stock) {
        try {
            Producto productoNuevo = new Producto();
            productoNuevo.setNombre(nombre);
            productoNuevo.setDescripcion(descripcion);
            daoProducto.guardaProducto(productoNuevo);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el nuevo producto de manera correcta");
        }
    }

    public void listarProductos() throws Exception {
        List<Producto> todosProductos = daoProducto.listarTodos();
        imprimirLista(todosProductos);
    }

    private void imprimirLista(List<Producto> listaRecibida) {
        for (Producto unitarioProducto : listaRecibida) {
            System.out.println(unitarioProducto.getId_producto() + "-" + unitarioProducto.getNombre() + "-"
                    + unitarioProducto.getDescripcion());
        }
    }

    public void listarProductosPorDetalle(String nombreProducto) {
        try {
            List<Producto> productos = daoProducto.listarProductosPorDetalle(nombreProducto);
            System.out.println("Productos que contienen '" + nombreProducto + "' en su detalle:");
            for (Producto producto : productos) {
                System.out.println(producto.getNombre() + " - " + producto.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println("Error al listar productos por detalle: " + e.getMessage());
        }
    }

    public void listarTop10ProductosMasVendidos() {
        try {
            List<Object[]> productosMasVendidos = daoProducto.listarTop10ProductosMasVendidos();
            System.out.println("Top 10 productos más vendidos:");
            for (Object[] resultado : productosMasVendidos) {
                String nombreProducto = (String) resultado[0];
                Long totalVendido = (Long) resultado[1];
                System.out.println(nombreProducto + " - Cantidad vendida: " + totalVendido);
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos más vendidos: " + e.getMessage());
        }
    }
    
}
