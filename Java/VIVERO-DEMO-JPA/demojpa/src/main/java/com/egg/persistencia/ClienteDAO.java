package com.egg.persistencia;

import com.egg.entidades.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ClienteDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarCliente(Cliente cliente) throws Exception {
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
    }

    public Cliente buscarClientePorId(int idCliente) {
        return em.find(Cliente.class, idCliente);
    }

    public List<Cliente> listarTodos() throws Exception {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    public List<Cliente> listarClientesPorNombre(String nombreABuscar) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nombreContacto LIKE :nombre", Cliente.class)
                .setParameter("nombre", "%" + nombreABuscar + "%")
                .getResultList();
    }

    public List<Cliente> listarClientesPorCiudad(String ciudad) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.ciudad = :ciudad", Cliente.class)
                 .setParameter("ciudad", ciudad)
                 .getResultList();
    }

    public List<Cliente> listarClientesPorEmpleado(int idEmpleado) throws Exception {
        return em.createQuery("SELECT c FROM Cliente c WHERE c.empleado.id_empleado = :idEmpleado", Cliente.class)
                 .setParameter("idEmpleado", idEmpleado)
                 .getResultList();
    }
    
}
