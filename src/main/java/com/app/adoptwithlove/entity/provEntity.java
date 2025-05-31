package com.app.adoptwithlove.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="ejemplo")
public class provEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejemplo", nullable = false)
    private  Long id;

    @Column(name = "atributo1", nullable = false)
    private Boolean atributo1;

    @Column(name="atributo2", nullable = false, length = 100)
    private String atributo2;

    @Column(name="atributo3", nullable = false)
    private String atributo3;

    @Column(name="atributo4", nullable = false, length = 100)
    private String atributo4;

    @Column(name="atributo5", nullable = false, length = 100)
    private String atributo5;

}
