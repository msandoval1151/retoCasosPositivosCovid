package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.IOException;
import java.util.List;

import com.example.demo.controller.BucketController;
import com.example.demo.controller.DatosController;
import com.example.demo.controller.HomeController;
import com.example.demo.repository.Resultados;

@SpringBootTest
class RetoApplicationTests {

	@Autowired
	private HomeController homeController;
	@Autowired
	private DatosController datosController;
	@Autowired
	private BucketController bucketController;
	
	@Test
	void saludar() {
		String nombre = homeController.saludar("miguel");
		assertEquals(nombre, "{\"nombre\":\"miguel\"}");
	}
	
	@Test
	void descargar() throws IOException {
		Resultados resultados = datosController.calcular();
		assertEquals(661, resultados.getTotalContagiados());
	}
	
	@Test
	void listarBucket() throws IOException {
		ResponseEntity<List<String>> fileList = bucketController.listFiles();
		assumeTrue(0<fileList.getBody().size());
	}
}
