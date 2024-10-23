package com.egg.persistencias;

import com.egg.entidades.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AutorDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public List<Autor> buscarPorNombre(String nombre) {
        TypedQuery<Autor> query = em.createQuery(
                "SELECT a FROM Autor a WHERE a.nombre LIKE :nombre", Autor.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    public boolean existeAutorPorNombre(String nombre) {
        return !buscarPorNombre(nombre).isEmpty();
    }

    public void guardar(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void cerrar() {
        em.close();
        emf.close();
    }
}
