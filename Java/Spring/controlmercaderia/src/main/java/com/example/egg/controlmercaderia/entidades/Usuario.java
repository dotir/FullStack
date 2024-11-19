package com.example.egg.controlmercaderia.entidades;

import jakarta.persistence.EnumType; 
import jakarta.persistence.Enumerated; 
import jakarta.persistence.Id; 
import lombok.AllArgsConstructor; 
import lombok.Getter; 
import lombok.NoArgsConstructor; 
import lombok.Setter; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Entity; 

import com.example.egg.controlmercaderia.enumeraciones.Rol;

import jakarta.persistence.Column;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario; // Changed from String to Long

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.USER;

}
