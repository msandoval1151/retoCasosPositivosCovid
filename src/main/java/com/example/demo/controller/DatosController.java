package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.PositivosCovid;
import com.example.demo.repository.Resultados;

@RestController
public class DatosController {

	@GetMapping(path = "/descargar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resultados calcular() throws IOException {
		Path filePath = Paths.get("C:\\Users\\Miguel\\Documents\\dataset.csv");
		int contadorContagiados = 0, mayorContagiados = 0, menorContagiados = 100000000, totalcontagiados = 0, mayorMesContagiados = 0, menorMesContagiados = 100000000;
		String mayorDia = "", menorDia = "", mayorMes = "", menorMes = "";
		double promedioContagiados = 0.00;
		Resultados resultados = new Resultados();
		ArrayList<PositivosCovid> positivosMesList = new ArrayList<>();
		ArrayList<PositivosCovid> positivosTotalList = new ArrayList<>();
		List<String> mesAnioList = new ArrayList<>();
		try {
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] datosLinea = linea.split(",");
				contadorContagiados++;

				if (mayorContagiados < Integer.parseInt(datosLinea[3])) {
					mayorContagiados = Integer.parseInt(datosLinea[3]);
					mayorDia = datosLinea[0];
				}
				if (totalcontagiados < Integer.parseInt(datosLinea[4])) {
					totalcontagiados = Integer.parseInt(datosLinea[4]);
				}
				if (menorContagiados > Integer.parseInt(datosLinea[3])) {
					menorContagiados = Integer.parseInt(datosLinea[3]);
					menorDia = datosLinea[0];
				}
				positivosTotalList.add(new PositivosCovid(Integer.parseInt(datosLinea[3]), datosLinea[0].substring(0, 7)));
				mesAnioList.add(datosLinea[0].substring(0, 7));
			}

		} catch (Exception e) {
			System.out.print(e);
		}
		
		List<String> mesDistinct = mesAnioList.stream().distinct().collect(Collectors.toList());

		for(String mesAnio: mesDistinct) {
			int casosMes = 0;
			for(PositivosCovid positivo : positivosTotalList) {
				if(positivo.getMesAnio().equals(mesAnio)) {
					casosMes += positivo.getCasosPositivos();
				}
			}
			positivosMesList.add(new PositivosCovid(casosMes,mesAnio));
			
			if (mayorMesContagiados < casosMes) {
				mayorMesContagiados = casosMes;
				mayorMes = mesAnio;
			}
			if (menorMesContagiados > casosMes) {
				menorMesContagiados = casosMes;
				menorMes = mesAnio;
			}
			
			System.out.println(positivosMesList);
		}
		
		promedioContagiados = totalcontagiados / contadorContagiados;
		resultados.setTotalContagiados(contadorContagiados);
		resultados.setMayorNumeroMesContagiados(mayorMes);
		resultados.setMenorNumeroMesContagiados(menorMes);
		resultados.setMayorNumeroDiaContagiados(mayorDia);
		resultados.setMenorNumeroDiaContagiados(menorDia);
		resultados.setPromedioContagiados(promedioContagiados);
		return resultados;
	}

}
