package com.libreriapi.libreirapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libreriapi.libreirapi.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
