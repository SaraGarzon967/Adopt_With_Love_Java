package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name ="animal")
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private  Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name="edad", nullable = false, length = 100)
    private Integer edad;

    @Column(name="raza", nullable = false)
    private String raza;

    @Column(name="tipo_animal", nullable = false, length = 100)
    private String tipo_animal;

    @ManyToOne
    @JoinColumn(name = "fundacion_id_fundacion")
    private Fundacion fundacion;

    @OneToMany(mappedBy = "animal")
    private List<Adopcion> adopciones;
}
