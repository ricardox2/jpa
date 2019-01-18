package com.venta.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="factura")

public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nrofactura;
	private Date fecha;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNrofactura() {
		return nrofactura;
	}
	public void setNrofactura(String nrofactura) {
		this.nrofactura = nrofactura;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Factura(String nrofactura, Date fecha, Cliente cliente) {
		super();
		this.nrofactura = nrofactura;
		this.fecha = fecha;
		this.cliente = cliente;
	}
	public Factura(int id) {
		super();
		this.id = id;
	}
	public Factura() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((nrofactura == null) ? 0 : nrofactura.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (nrofactura == null) {
			if (other.nrofactura != null)
				return false;
		} else if (!nrofactura.equals(other.nrofactura))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
