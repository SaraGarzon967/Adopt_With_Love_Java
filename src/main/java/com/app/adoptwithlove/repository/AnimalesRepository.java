package com.app.adoptwithlove.repository;

import com.app.adoptwithlove.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalesRepository extends JpaRepository<Animal, Long> {

}
