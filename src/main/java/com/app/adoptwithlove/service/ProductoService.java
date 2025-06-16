package com.app.adoptwithlove.service;

import com.app.adoptwithlove.entity.Productos;
import com.app.adoptwithlove.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productosRepository;

    
    public List<Productos> obtenerTodosLosProductos() {
        return productosRepository.findAll();
    }

    
    public Optional<Productos> obtenerProductoPorId(Long id) {
        return productosRepository.findById(id);
    }

    
    public Productos guardarProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    public Productos actualizarProducto(Long id, Productos productoActualizado) {
        return productosRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setTipoProducto(productoActualizado.getTipoProducto());
            return productosRepository.save(producto);
        }).orElse(null);
    }


    public boolean eliminarProducto(Long id) {
        if (productosRepository.existsById(id)) {
            productosRepository.deleteById(id);
            return true;
        }
        return false ;
    }
}
