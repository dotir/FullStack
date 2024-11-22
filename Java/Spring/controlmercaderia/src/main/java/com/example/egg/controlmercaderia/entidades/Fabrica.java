package com.example.egg.controlmercaderia.entidades;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @UuidGenerator
    @Column(columnDefinition = "VARCHAR(36)")
    private String idFabrica;

    @Column(nullable = false)
    private String nombreFabrica;

}
