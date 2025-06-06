package com.app.adoptwithlove.service.Dao;
import com.app.adoptwithlove.entity.Fundacion;
import jakarta.transaction.Transactional;

import java.util.List;

public interface Idao<T, ID> {
    List<T> getAll();
    T getById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}
