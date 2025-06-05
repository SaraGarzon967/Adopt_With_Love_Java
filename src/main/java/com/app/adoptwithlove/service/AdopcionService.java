package com.app.adoptwithlove.service;

import com.app.adoptwithlove.entity.Adopcion;
import com.app.adoptwithlove.repository.AdopcionRepository;
import com.app.adoptwithlove.service.Dao.Idao;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdopcionService implements Idao<Adopcion, Long> {

    @Autowired
    private AdopcionRepository adopcionRepository;

    @Override
    public List<Adopcion> getAll() {
        return adopcionRepository.findAll();
    }

    @Override
    public Adopcion getById(Long id) {
        return adopcionRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Adopcion create(Adopcion entity) {
        return adopcionRepository.save(entity);
    }

    @Transactional
    @Override
    public Adopcion update(Long id, Adopcion entity) {
        if (adopcionRepository.existsById(id)) {
            entity.setId(id); // Asegurar que el ID no cambie
            return adopcionRepository.save(entity);
        }
        return null;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        adopcionRepository.deleteById(id);
    }
}
