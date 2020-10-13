package com.ekeepoit.facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekeepoit.facturacion.dto.FacturaDTO;
import com.ekeepoit.facturacion.dto.Response;
import com.ekeepoit.facturacion.service.FacturaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/facturas")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;

	@PostMapping
    public ResponseEntity<?> save(@RequestBody FacturaDTO facturaDTO) throws Exception {
        Response response = facturaService.save(facturaDTO);
        return ResponseEntity.ok().body(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<Response> get(@PathVariable("id") int id) throws Exception {
		Response response = facturaService.findOneById(String.valueOf(id));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping()
	public ResponseEntity<?> list() throws Exception {
		Response response = facturaService.findAll();
		return ResponseEntity.ok().body(response);
	}

}
