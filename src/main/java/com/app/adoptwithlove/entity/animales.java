package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="fundacion")
@Data
public class animales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private  Long id;

    @Column(name = "nombre", nullable = false)
    private Boolean nombre;

    @Column(name="edad", nullable = false, length = 100)
    private String edad;

    @Column(name="raza", nullable = false)
    private String raza;

    @Column(name="tipo_animal", nullable = false, length = 100)
    private String tipo_animal;

}
