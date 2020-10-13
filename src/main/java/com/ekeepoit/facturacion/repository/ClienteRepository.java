package com.ekeepoit.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ekeepoit.facturacion.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}