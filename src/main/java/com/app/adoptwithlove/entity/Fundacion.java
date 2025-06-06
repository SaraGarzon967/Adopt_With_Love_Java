package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name ="fundacion")
@Data
public class Fundacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fundacion", nullable = false)
    private Long id;

    @Column(name = "nombre_fundacion", nullable = false)
    private String nombre_fundacion;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "persona_id_persona")
    private Persona persona;

    @OneToMany(mappedBy = "fundacion")
    private List<Animal> animales;
}
