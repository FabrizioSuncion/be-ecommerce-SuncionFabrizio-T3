package com.ecommerce.suncionfabrizio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.suncionfabrizio.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(name = "Producto.buscarPorCategoria")
    List<Producto> buscarPorCategoria(@Param("categoria") String categoria);

    @Query(name = "Producto.buscarPorNombre")
    List<Producto> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Producto p WHERE p.marca = :marca")
    List<Producto> buscarPorMarca(@Param("marca") String marca);
}
