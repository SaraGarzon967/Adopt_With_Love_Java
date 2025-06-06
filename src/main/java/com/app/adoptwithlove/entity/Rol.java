package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name ="rol")
@Data

public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private Long id;

    @Column(name = "nombreRol", nullable = false)
    private String nombreRol;

    @OneToOne(mappedBy = "rol") // referencia inversa, no tiene FK aquí
    private Persona persona;
}
