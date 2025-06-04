package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="persona")
@Data
public class persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private  Long id;

    @Column(name = "nombre", nullable = false)
    private Boolean nombre;

    @Column(name="apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name="contacto", nullable = false)
    private String contacto;

    @Column(name="fecha_nacimiento", nullable = false, length = 100)
    private String fecha_nacimiento;

    @Column(name="contrasena", nullable = false, length = 100)
    private String contrasena;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private rol rol;
}
