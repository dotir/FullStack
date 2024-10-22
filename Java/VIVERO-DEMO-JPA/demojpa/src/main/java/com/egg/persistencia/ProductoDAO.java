package com.egg.persistencia;

import com.egg.entidades.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ProductoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaProducto(Producto producto) throws Exception {
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
    }

    public List<Producto> listarTodos() throws Exception {
        return em.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    public List<Producto> listarProductosPorDetalle(String nombreProducto) {
        return em.createQuery("SELECT DISTINCT p FROM Producto p WHERE LOWER(p.nombre) LIKE LOWER(:nombre)", Producto.class)
                 .setParameter("nombre", "%" + nombreProducto + "%")
                 .getResultList();
    }

    public List<Object[]> listarTop10ProductosMasVendidos() {
    return em.createQuery(
        "SELECT p.nombre, SUM(dp.cantidad) as totalVendido " +
        "FROM DetallePedido dp " +
        "JOIN dp.producto p " +
        "GROUP BY p.nombre " +
        "ORDER BY totalVendido DESC", Object[].class)
        .setMaxResults(10)
        .getResultList();
}

}