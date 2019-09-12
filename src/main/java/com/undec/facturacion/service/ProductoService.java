package com.undec.facturacion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.*;

import com.undec.facturacion.dto.Response;
import com.undec.facturacion.model.Producto;
import com.undec.facturacion.repository.*;

/**
 * @author etorrielli
 */
@Service
public class ProductoService {

    static final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    @Autowired
    private ProductoRepository productoRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Producto> productoList = productoRepository.findAll();
            response.setData(productoList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }
}