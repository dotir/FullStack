package com.example.egg.controlmercaderia.entidades;

import jakarta.persistence.*;
import lombok.*;
import com.example.egg.controlmercaderia.enumeraciones.Rol;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "VARCHAR(36)")
    private String idUsuario;

    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)  
    private String apellido;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol = Rol.USER;
}
