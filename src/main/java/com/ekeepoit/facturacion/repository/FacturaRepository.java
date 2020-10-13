package com.ekeepoit.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ekeepoit.facturacion.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}