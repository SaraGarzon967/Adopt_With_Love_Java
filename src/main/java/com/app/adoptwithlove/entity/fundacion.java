package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="fundacion")
@Data
public class fundacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fundacion", nullable = false)
    private Long id;

    @Column(name = "nombre_fundacion", nullable = false)
    private Boolean nombre_fundacion;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 100)
    private String telefono;

}
