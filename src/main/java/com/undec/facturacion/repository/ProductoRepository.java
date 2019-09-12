package com.undec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.undec.facturacion.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}