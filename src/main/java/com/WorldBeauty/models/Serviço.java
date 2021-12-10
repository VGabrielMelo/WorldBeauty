package com.WorldBeauty.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Serviço {

	@Id 
	private String id;
	
	private String DescriçãoServiço;
	
	@ManyToOne
	private Cliente cliente;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescriçãoServiço() {
		return DescriçãoServiço;
	}

	public void setDescriçãoServiço(String descriçãoServiço) {
		DescriçãoServiço = descriçãoServiço;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
