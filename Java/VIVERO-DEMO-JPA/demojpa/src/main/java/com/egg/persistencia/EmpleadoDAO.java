package com.egg.persistencia;

import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class EmpleadoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void agregarEmpleado(Empleado empleado) throws Exception {
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();
    }

    public void modificarEmpleado(Empleado empleado) throws Exception {
        em.getTransaction().begin();
        em.merge(empleado);
        em.getTransaction().commit();
    }

    public Empleado buscarEmpleadoPorId(int idEmpleado) {
        return em.find(Empleado.class, idEmpleado);
    }

    public void removerEmpleado(int idEmpleado) throws Exception {
        Empleado empleado = em.find(Empleado.class, idEmpleado);
        if (empleado != null) {
            em.getTransaction().begin();
            em.remove(empleado);
            em.getTransaction().commit();
        }
    }

    public List<Empleado> listarTodos() throws Exception {
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }

    public List<Empleado> listarEmpleadosPorOficina(int id_oficina) throws Exception {
        return em.createQuery("SELECT e FROM Empleado e WHERE e.oficina.id_oficina = :id_oficina", Empleado.class)
                 .setParameter("id_oficina", id_oficina)
                 .getResultList();
    }

    public List<Empleado> listarEmpleadosPorOficinaCodigoONombre(String codigoONombre) throws Exception {
        return em.createQuery("SELECT e FROM Empleado e WHERE e.oficina.codigo_oficina = :codigoONombre OR e.oficina.ciudad = :codigoONombre", Empleado.class)
                 .setParameter("codigoONombre", codigoONombre)
                 .getResultList();
    }

    public List<Empleado> listarEmpleadosJefes() throws Exception {
        return em.createQuery("SELECT DISTINCT e FROM Empleado e WHERE EXISTS (SELECT 1 FROM Empleado sub WHERE sub.jefe = e)", Empleado.class)
                 .getResultList();
    }
    
    
}