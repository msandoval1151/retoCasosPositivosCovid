package com.example.demo.repository;

public class PositivosCovid {
	
	private int casosPositivos;
	private String mesAnio;
	
	public PositivosCovid() {
	}

	public PositivosCovid(int casosPositivos, String mesAnio) {
		super();
		this.casosPositivos = casosPositivos;
		this.mesAnio = mesAnio;
	}

	public int getCasosPositivos() {
		return casosPositivos;
	}

	public void setCasosPositivos(int casosPositivos) {
		this.casosPositivos = casosPositivos;
	}

	public String getMesAnio() {
		return mesAnio;
	}

	public void setMesAnio(String mesAnio) {
		this.mesAnio = mesAnio;
	}
	

}
