package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.Usuario;
import com.google.gson.Gson;

@RestController
public class HomeController {
	
	@GetMapping(path = "/saludar/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String saludar(@PathVariable("nombre") String nombre) {
		System.out.print("llego controller");
		Gson g = new Gson();
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		return g.toJson(usuario);
	}
}
