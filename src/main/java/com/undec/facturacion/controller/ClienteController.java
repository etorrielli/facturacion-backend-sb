package com.undec.facturacion.controller;

import com.undec.facturacion.dto.Response;
import com.undec.facturacion.model.Cliente;
import com.undec.facturacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") int id) throws Exception {
        Response response = clienteService.findOneById(String.valueOf(id));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = clienteService.findAll();
        return ResponseEntity.ok().body(response);
    }

}
