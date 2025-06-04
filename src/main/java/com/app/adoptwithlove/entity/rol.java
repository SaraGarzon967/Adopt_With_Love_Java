package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="rol")
@Data

public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private  Long id;

    @Column(name = "nombreRol", nullable = false)
    private Boolean nombreRol;
}
