package com.app.adoptwithlove.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.adoptwithlove.entity.Adopcion;

@Repository
public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {

}
