package com.app.adoptwithlove.service.Dao;
import java.util.List;

public interface Idao<T, ID> {
    // 1.metodo para listar los registros de cada entidad
    List<T> getAll();
    T getById(ID id);
    //2. metodo para un nuevo registro en las entidades
    T create(T entity);
    // 3. metodos para realizar actualizaciones
    T update(ID id, T entity);
    // 4. metodo para eliminar registros
    void delete(ID id);
}
