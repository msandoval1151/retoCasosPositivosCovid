package com.example.demo.repository;

public class Resultados {
	
	private int totalContagiados;
	private Double promedioContagiados;
	private String menorNumeroMesContagiados;
	private String mayorNumeroMesContagiados;
	private String mayorNumeroDiaContagiados;
	private String menorNumeroDiaContagiados;
	
	public Resultados() {
	}

	public int getTotalContagiados() {
		return totalContagiados;
	}


	public void setTotalContagiados(int totalContagiados) {
		this.totalContagiados = totalContagiados;
	}


	public Double getPromedioContagiados() {
		return promedioContagiados;
	}

	public void setPromedioContagiados(Double promedioContagiados) {
		this.promedioContagiados = promedioContagiados;
	}

	public String getMenorNumeroMesContagiados() {
		return menorNumeroMesContagiados;
	}

	public void setMenorNumeroMesContagiados(String menorNumeroMesContagiados) {
		this.menorNumeroMesContagiados = menorNumeroMesContagiados;
	}

	public String getMayorNumeroMesContagiados() {
		return mayorNumeroMesContagiados;
	}

	public void setMayorNumeroMesContagiados(String mayorNumeroMesContagiados) {
		this.mayorNumeroMesContagiados = mayorNumeroMesContagiados;
	}

	public String getMayorNumeroDiaContagiados() {
		return mayorNumeroDiaContagiados;
	}

	public void setMayorNumeroDiaContagiados(String mayorNumeroDiaContagiados) {
		this.mayorNumeroDiaContagiados = mayorNumeroDiaContagiados;
	}

	public String getMenorNumeroDiaContagiados() {
		return menorNumeroDiaContagiados;
	}

	public void setMenorNumeroDiaContagiados(String menorNumeroDiaContagiados) {
		this.menorNumeroDiaContagiados = menorNumeroDiaContagiados;
	}
	
}
