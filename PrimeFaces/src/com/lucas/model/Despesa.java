package com.lucas.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Despesa {
	
	//É importante não usar tipos primitivos ao trabalhar com o Prime Faces, sempre lembrar de trabalhar com classes Wappers

	private static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer id;
	private Date data;
	private String descricao;
	private String categoria;
	private Double valor;
	
	public Despesa(int id, String data, String descricao, String categoria, double valor) {
		this.id = id;
		
		try {
			this.data = format.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.descricao = descricao;
		this.categoria = categoria;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public static SimpleDateFormat getFormat() {
		return format;
	}
	
	
	
}
