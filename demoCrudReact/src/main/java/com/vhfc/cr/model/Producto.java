package com.vhfc.cr.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Entity

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String nombre;
    private String codigo;
    private Float precio;
    private Float existencia;


    public Producto(Long id, String nombre, String codigo, Float precio, Float existencia ) {
    	this.id = id;
    	this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencia = existencia;
     
    }

    public Producto(String nombre, String codigo, Float precio, Float existencia) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.existencia = existencia;
    }

    public Producto() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getExistencia() {
		return existencia;
	}

	public void setExistencia(Float existencia) {
		this.existencia = existencia;
	}
    
    
}
