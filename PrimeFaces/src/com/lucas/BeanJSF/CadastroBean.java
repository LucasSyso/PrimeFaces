package com.lucas.BeanJSF;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.lucas.model.Cliente;

@Named
@RequestScoped
@SuppressWarnings("serial")
public class CadastroBean implements Serializable{

	@Inject
	private FacesContext context;
	
	private Cliente cliente = new Cliente();
	
	private String[] interesses = {
		"Esporte",
		"Cinema",
		"Viagens",
		"Culinaria"
	};
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String[] getInteresses() {
		return interesses;
	}
	
	public void setInteresses(String[] interesses) {
		this.interesses = interesses;
	}
	
	public String cadastrar() {
		System.out.println("Cliente: + " + cliente);
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Cadastro realizado com sucesso");
		context.addMessage(null, msg);
		
		return null;
	}
	
}
