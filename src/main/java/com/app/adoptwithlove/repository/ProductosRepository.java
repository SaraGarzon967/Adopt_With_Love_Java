package com.app.adoptwithlove.repository;

import com.app.adoptwithlove.entity.Persona;
import com.app.adoptwithlove.entity.Productos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByPersona(Persona persona);
    List<Productos> findByPersonaEmail(String email);
}
