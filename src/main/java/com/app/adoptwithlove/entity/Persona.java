package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name ="persona")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private  Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name="contacto", nullable = false)
    private String contacto;

    @Column(name="fecha_nacimiento", nullable = false, length = 100)
    private String fecha_nacimiento;

    @Column(name="contrasena", nullable = false, length = 100)
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "rol_id_rol")  // FK en persona
    private Rol rol;

    @OneToMany(mappedBy = "persona")
    private List<Fundacion> fundaciones;

    @OneToMany(mappedBy = "persona")
    private List<Productos> productos;

    @OneToMany(mappedBy = "persona")
    private List<Adopcion> adopciones;
}
