package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Datos;
import com.example.demo.repository.Resultados;

@RestController
public class DatosController {
	
	@Autowired
	public Datos datos;

	@GetMapping(path = "/descargar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resultados calcular() throws IOException {
		return datos.calcular();
	}

}
