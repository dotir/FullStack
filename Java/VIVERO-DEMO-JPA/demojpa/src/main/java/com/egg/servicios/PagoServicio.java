package com.egg.servicios;

import com.egg.entidades.Pago;
import com.egg.persistencia.PagoDAO;
import java.util.Date;
import java.util.List;

public class PagoServicio {
    private final PagoDAO daoPago;

    public PagoServicio() {
        this.daoPago = new PagoDAO();
    }

    public void listarPagosPorRangoFechas(Date fechaInicio, Date fechaFin) {
        try {
            List<Pago> pagos = daoPago.listarPagosPorRangoFechas(fechaInicio, fechaFin);
            System.out.println("Pagos realizados entre " + fechaInicio + " y " + fechaFin + ":");
            for (Pago pago : pagos) {
                System.out.println("ID Transacción: " + pago.getId_transaccion() + 
                                   ", Fecha: " + pago.getFecha_pago() + 
                                   ", Cantidad: " + pago.getTotal());
            }
        } catch (Exception e) {
            System.out.println("Error al listar pagos: " + e.getMessage());
        }
    }
}
