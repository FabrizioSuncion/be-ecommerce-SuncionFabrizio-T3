package com.ecommerce.suncionfabrizio.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.suncionfabrizio.dto.ProductoDTO;
import com.ecommerce.suncionfabrizio.model.Producto;
import com.ecommerce.suncionfabrizio.repository.ProductoRepository;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> listar() {
        return productoRepository.findAll().stream().map(this::toDTO).toList();
    }

    public ProductoDTO obtener(Long id) {
        return toDTO(buscar(id));
    }

    public ProductoDTO crear(ProductoDTO dto) {
        Producto p = new Producto();
        copiar(dto, p);
        return toDTO(productoRepository.save(p));
    }

    public ProductoDTO actualizar(Long id, ProductoDTO dto) {
        Producto p = buscar(id);
        copiar(dto, p);
        return toDTO(productoRepository.save(p));
    }

    public void eliminar(Long id) {
        productoRepository.delete(buscar(id));
    }

    public List<ProductoDTO> buscarPorCategoria(String categoria) {
        return productoRepository.buscarPorCategoria(categoria).stream().map(this::toDTO).toList();
    }

    private Producto buscar(Long id) {
        return productoRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado con id " + id));
    }

    private void copiar(ProductoDTO dto, Producto p) {
        p.setNombre(dto.getNombre());
        p.setCategoria(dto.getCategoria());
        p.setPrecioCompra(dto.getPrecioCompra());
        p.setPrecioVenta(dto.getPrecioVenta());
        p.setStock(dto.getStock());
        p.setMarca(dto.getMarca());
        p.setCodigoBarras(dto.getCodigoBarras());
        p.setFechaIngreso(dto.getFechaIngreso());
    }

    private ProductoDTO toDTO(Producto p) {
        return new ProductoDTO(p.getId(), p.getNombre(), p.getCategoria(), p.getPrecioCompra(),
            p.getPrecioVenta(), p.getStock(), p.getMarca(), p.getCodigoBarras(), p.getFechaIngreso());
    }
}
