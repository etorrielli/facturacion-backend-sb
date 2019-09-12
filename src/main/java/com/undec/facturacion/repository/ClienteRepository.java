package com.undec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.undec.facturacion.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}