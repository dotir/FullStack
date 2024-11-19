package com.example.egg.controlmercaderia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fabrica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFabrica; // Changed from String to Long

    @Column(nullable = false)
    private String nombreFabrica;

}
