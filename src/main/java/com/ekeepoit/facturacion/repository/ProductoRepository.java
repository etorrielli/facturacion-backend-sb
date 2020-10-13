package com.ekeepoit.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ekeepoit.facturacion.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}