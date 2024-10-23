package com.egg.persistencias;

import com.egg.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();
    
    public Libro buscarPorISBN(String isbn) {
        TypedQuery<Libro> query = em.createQuery(
            "SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        TypedQuery<Libro> query = em.createQuery(
            "SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class);
        query.setParameter("titulo", "%" + titulo + "%");
        return query.getResultList();
    }

    public List<Libro> buscarPorEditorial(String nombreEditorial) {
        TypedQuery<Libro> query = em.createQuery(
            "SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre LIKE :nombreEditorial", 
            Libro.class);
        query.setParameter("nombreEditorial", "%" + nombreEditorial + "%");
        return query.getResultList();
    }
    
    public void guardar(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }
    
    public void cerrar() {
        em.close();
        emf.close();
    }
}
