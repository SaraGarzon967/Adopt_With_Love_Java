package com.app.adoptwithlove.service;

import com.app.adoptwithlove.entity.Animal;
import com.app.adoptwithlove.repository.AnimalesRepository;
import com.app.adoptwithlove.service.Dao.Idao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AnimalService implements Idao<Animal, Long> {

    @Autowired
    private AnimalesRepository Animal;

    @Override
    public List<Animal> getAll() {
        return Animal.findAll();
    }

    @Override
    public Animal getById(Long id) {
        return Animal.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Animal create(Animal entity) {
        return Animal.save(entity);
    }

    @Transactional
    @Override
    public Animal update(Long id, Animal entity) {
        return Animal.save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Animal.deleteById(id);
    }
}
