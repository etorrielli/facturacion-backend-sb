package com.undec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.undec.facturacion.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}