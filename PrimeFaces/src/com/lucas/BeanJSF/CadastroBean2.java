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
	
	private List<String> cidades = List.of("Brasília", "Londres", "Paris", "Buenos Aires", "Berlin");
	
	private String cidade;
	private String pais = "Brasil";
	
	/*
	 * 	O atributo 'query' é o que o usuário já digitou até o momento
	 *	Como critérios de filtragem, o código obtem a lista 'cidades', converte para um stream, e, usando expressões lâmbida, faz um filtro,
	 * procurando se as palavras digitadas são encontradas nas iniciais das cidades contidas na lista.
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
