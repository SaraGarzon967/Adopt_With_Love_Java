package com.app.adoptwithlove.Controller;


import com.app.adoptwithlove.Dto.ProductoDTO;
import com.app.adoptwithlove.Dto.productoDTO;
import com.app.adoptwithlove.entity.Productos;
import com.app.adoptwithlove.entity.Vendedor;
import com.app.adoptwithlove.repository.ProductoRepository;
import com.app.adoptwithlove.repository.VendedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @GetMapping
    public List<Productos> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping
    public Productos createProducto(@RequestBody ProductoDTO productoDTO) {
        Vendedor vendedor = vendedorRepository.findById(productoDTO.getVendedorId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
        
        Productos producto = new Productos();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setCantidad(productoDTO.getCantidad());
        producto.setTipoProducto(productoDTO.getTipoProducto());
        producto.setVendedor(vendedor);

        return productoRepository.save(producto);
    }
}
