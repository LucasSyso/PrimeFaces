package com.lucas.BeanJSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.lucas.model.Despesa;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class TableBean implements Serializable{
	
	@Inject
	FacesContext context;

	private static List<Despesa> despesas = new ArrayList<>();
	
	private Despesa[] selectedDespesas;
	private List<String> categorias = List.of("Alimentacao", "Escritorio", "Estudos", "Compras", "Leitura", "Pagamentos");
	
	static {
		despesas.add(new Despesa(1, "02/10/2019", "Restaurante Burguer King", "Alimentação", 45.0));
		despesas.add(new Despesa(2, "03/10/2019", "Resma de papel", "Escritório", 25.0));
		despesas.add(new Despesa(3, "04/10/2019", "Lápis de cor", "Faculdade Gabrielle", 14.0));
		despesas.add(new Despesa(4, "05/10/2019", "Panos de chão", "Compras casa", 20.0));
		despesas.add(new Despesa(5, "06/10/2019", "Fitas", "Compras casa", 10.0));
		despesas.add(new Despesa(6, "07/10/2019", "Restaurante Dellano", "Alimentação", 100.0));
		despesas.add(new Despesa(7, "08/10/2019", "Pizzaria Parmê", "Alimentação", 45.0));
		despesas.add(new Despesa(8, "09/10/2019", "Livro", "Leitura", 45.0));
		despesas.add(new Despesa(9, "10/10/2019", "Compras", "Compras casa", 450.0));
		despesas.add(new Despesa(10, "11/10/2019", "Contas de casa", "Boletos", 400.0));
	}
	
	public List<Despesa> getDespesas() {
		return despesas;
	}
	
	public Despesa[] getSelectedDespesas() {
		return selectedDespesas;
	}
	
	public void setSelectedDespesas(Despesa[] selectedDespesas) {
		this.selectedDespesas = selectedDespesas;
	}
	
	public List<String> getCategorias() {
		return categorias;
	}
	
	public void processar() {
		StringBuilder builder = new StringBuilder("Despesas selecionadas: ");
		
		for(Despesa d : selectedDespesas) {
			builder.append(d.getDescricao()).append(", ");
		}
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, builder.toString());
		context.addMessage(null, msg);
	}
	
	public void onEdit(RowEditEvent event) {
		Despesa despesa = (Despesa) event.getObject();
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "A despesa " + despesa.getDescricao() + " foi alterada!!");
		context.addMessage(null, msg);
	}
	
	public void onCancel(RowEditEvent event) {
		Despesa despesa = (Despesa) event.getObject();
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, null, "A alteração na despesa " + despesa.getDescricao() + " foi cancelada!!");
		context.addMessage(null, msg);
	}
	
}
