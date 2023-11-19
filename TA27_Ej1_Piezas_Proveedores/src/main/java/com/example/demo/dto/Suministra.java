package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio")
	private Integer precio;
	
	@ManyToOne
    @JoinColumn(name = "id_proveedor")
	@JsonIgnoreProperties("suministra")
    Proveedor proveedor;
 
    @ManyToOne
    @JoinColumn(name = "codigo_pieza")
	@JsonIgnoreProperties("suministra")
    Pieza pieza;
	
	
	public Suministra() {
	
	}
	
	public Suministra(Integer id, Integer precio, Proveedor proveedor, Pieza pieza) {
		super();
		this.id = id;
		this.precio = precio;
		this.proveedor = proveedor;
		this.pieza = pieza;
	}


	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	@Override
	public String toString() {
		return "Suministra [id=" + id + ", precio=" + precio + ", proveedor=" + proveedor + ", pieza=" + pieza + "]";
	}
}
