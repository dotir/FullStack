
package com.egg.persistencia;

import com.egg.entidades.Pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class PagoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public List<Pago> listarPagosPorRangoFechas(Date fechaInicio, Date fechaFin) {
        return em.createQuery("SELECT p FROM Pago p WHERE p.fecha_pago BETWEEN :fechaInicio AND :fechaFin", Pago.class)
                 .setParameter("fechaInicio", fechaInicio)
                 .setParameter("fechaFin", fechaFin)
                 .getResultList();
    }
}
