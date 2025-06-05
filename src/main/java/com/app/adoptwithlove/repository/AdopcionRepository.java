package com.app.adoptwithlove.repository;

import com.app.adoptwithlove.entity.Adopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {

}
