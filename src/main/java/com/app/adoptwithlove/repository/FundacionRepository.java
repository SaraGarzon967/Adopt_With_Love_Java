package com.app.adoptwithlove.repository;

import com.app.adoptwithlove.entity.Fundacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundacionRepository extends JpaRepository<Fundacion, Long> {

}
