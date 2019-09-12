package com.undec.facturacion.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.undec.facturacion.dto.Response;
import com.undec.facturacion.model.Cliente;
import com.undec.facturacion.repository.*;

import javax.persistence.EntityNotFoundException;

/**
 * @author etorrielli
 */
@Service
public class ClienteService {

    static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private ClienteRepository clienteRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Cliente> clienteList = clienteRepository.findAll();
            response.setData(clienteList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response findOneById(String id) throws Exception {
        Response response = new Response();
        try {
            Cliente cliente = clienteRepository.findById(Integer.parseInt(id)).get();
            response.setData(cliente);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

}