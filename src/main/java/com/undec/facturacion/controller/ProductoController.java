package com.undec.facturacion.controller;

import com.undec.facturacion.dto.Response;
import com.undec.facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = productoService.findAll();
        return ResponseEntity.ok().body(response);
    }

}
