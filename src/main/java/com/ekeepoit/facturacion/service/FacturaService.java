package com.ekeepoit.facturacion.service;

import com.ekeepoit.facturacion.dto.DetalleDTO;
import com.ekeepoit.facturacion.dto.FacturaDTO;
import com.ekeepoit.facturacion.model.Detalle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.ekeepoit.facturacion.dto.Response;
import com.ekeepoit.facturacion.model.Factura;
import com.ekeepoit.facturacion.repository.*;


/**
 * @author etorrielli
 */
@Service
public class FacturaService {

    static final Logger LOGGER = LoggerFactory.getLogger(FacturaService.class);

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private DetalleRepository detalleRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        try {
            List<Factura> facturaList = facturaRepository.findAll();
            response.setData(facturaList);
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
            Factura factura = facturaRepository.findById(Integer.parseInt(id)).get();
            response.setData(factura);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response update(FacturaDTO input) throws Exception {
        Response response = new Response();
        try {
            Factura factura = facturaRepository.findById(input.getId()).get();
            facturaRepository.save(factura);

            response.setData(input);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    public Response save(FacturaDTO facturaDTO) throws Exception {
        Response response = new Response();
        try {
            Factura factura = facturaDTOToEntity(facturaDTO);
            factura = facturaRepository.save(factura);

            for (DetalleDTO item : facturaDTO.getDetalles()) {
                Detalle detalle = detalleDTOToEntity(factura, item);
                detalle = detalleRepository.save(detalle);
            }

            response.setData(factura.getId());

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return response;
    }

    private Factura facturaDTOToEntity(FacturaDTO facturaDTO) throws Exception {
        Factura factura = new Factura();
        factura.setFolio(facturaDTO.getFolio());
        factura.setDescripcion(facturaDTO.getDescripcion());
        factura.setObservacion(facturaDTO.getObservacion());
        factura.setFecha(new Date());
        factura.setClienteByClienteId(clienteRepository.getOne(facturaDTO.getClienteId()));
        return factura;
    }

    private Detalle detalleDTOToEntity(Factura factura, DetalleDTO detalleDTO) throws Exception {
        Detalle detalle = new Detalle();
        detalle.setCantidad(detalleDTO.getCantidad());
        detalle.setFacturaByFacturaId(factura);
        detalle.setProductoByProductoId(productoRepository.getOne(detalleDTO.getProductoId()));
        return detalle;
    }

}