package com.app.adoptwithlove.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="productos")
@Data
public class productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private  Long id;

    @Column(name = "nombre", nullable = false)
    private Boolean nombre;

    @Column(name="precio", nullable = false, length = 100)
    private Integer precio;

    @Column(name="tipoProducto", nullable = false)
    private String tipoProducto;
    
}
