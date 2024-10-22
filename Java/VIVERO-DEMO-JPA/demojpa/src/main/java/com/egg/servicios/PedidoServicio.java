package com.egg.servicios;

import com.egg.entidades.Pedido;
import com.egg.persistencia.PedidoDAO;

import java.util.List;
import java.util.Date;

public class PedidoServicio {
    private final PedidoDAO daoPedido;

    public PedidoServicio() {
        this.daoPedido = new PedidoDAO();
    }

    public void listarPedidosRetrasados() {
        try {
            List<Pedido> pedidosRetrasados = daoPedido.listarPedidosRetrasados();
            System.out.println("Pedidos entregados después de la fecha esperada:");
            for (Pedido pedido : pedidosRetrasados) {
                System.out.println("ID: " + pedido.getId_pedido() + 
                                   ", Fecha esperada: " + pedido.getFecha_esperada() + 
                                   ", Fecha entrega: " + pedido.getFecha_entrega());
            }
        } catch (Exception e) {
            System.out.println("Error al listar pedidos retrasados: " + e.getMessage());
        }
    }

    public void listarPedidosPorClienteYFechas(String nombreCliente, Date fechaInicio, Date fechaFin) {
        try {
            List<Pedido> pedidos = daoPedido.listarPedidosPorClienteYFechas(nombreCliente, fechaInicio, fechaFin);
            System.out.println("Pedidos de " + nombreCliente + " entre " + fechaInicio + " y " + fechaFin + ":");
            for (Pedido pedido : pedidos) {
                System.out.println("ID: " + pedido.getId_pedido() + 
                                ", Fecha: " + pedido.getFecha_pedido() + 
                                ", Estado: " + pedido.getEstado());
            }
        } catch (Exception e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }
    }
}