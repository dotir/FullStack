package com.egg.persistencias;

import com.egg.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EditorialDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    
    public void guardar(Editorial editorial) {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    //buscar por nombre
    public Editorial buscarPorNombre(String nombre) {
        return em.find(Editorial.class, nombre);
    }

    public boolean existeEditorialPorNombre(String nombre) {
        return buscarPorNombre(nombre) != null;
    }

    


    
    public void cerrar() {
        em.close();
        emf.close();
    }
}
