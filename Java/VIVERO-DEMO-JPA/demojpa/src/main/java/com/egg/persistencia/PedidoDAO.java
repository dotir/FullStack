package com.egg.persistencia;

import com.egg.entidades.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Date;

public class PedidoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();


    public List<Pedido> listarPedidosRetrasados() {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.fecha_entrega > p.fecha_esperada", Pedido.class)
                 .getResultList();
    }

    public List<Pedido> listarPedidosPorClienteYFechas(String nombreCliente, Date fechaInicio, Date fechaFin) {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.cliente.nombre_cliente = :nombre AND p.fecha_pedido BETWEEN :fechaInicio AND :fechaFin", Pedido.class)
                 .setParameter("nombre", nombreCliente)
                 .setParameter("fechaInicio", fechaInicio)
                 .setParameter("fechaFin", fechaFin)
                 .getResultList();
    }
}


