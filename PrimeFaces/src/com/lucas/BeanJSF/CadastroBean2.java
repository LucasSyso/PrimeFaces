package com.lucas.BeanJSF;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@SuppressWarnings("serial")
public class CadastroBean2 implements Serializable{

	@Inject
	private FacesContext context;
	
	private List<String> cidades = List.of("Bras�lia", "Londres", "Paris", "Buenos Aires", "Berlin");
	
	private String cidade;
	private String pais = "Brasil";
	
	/*
	 * 	O atributo 'query' � o que o usu�rio j� digitou at� o momento
	 *	Como crit�rios de filtragem, o c�digo obtem a lista 'cidades', converte para um stream, e, usando express�es l�mbida, faz um filtro,
	 * procurando se as palavras digitadas s�o encontradas nas iniciais das cidades contidas na lista.
	 * 
	 * */
	public List<String> listarCidades(String query){
		return cidades.stream().filter(c -> c.toUpperCase().startsWith(query.toUpperCase())).collect(Collectors.toList());
	}
	
	public String cadastrar() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cadastro realizado com sucesso!!");
		context.addMessage(null, msg);
		
		return null;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}
	

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
