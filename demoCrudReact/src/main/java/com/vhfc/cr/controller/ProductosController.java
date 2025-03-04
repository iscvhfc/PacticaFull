package com.vhfc.cr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.vhfc.cr.model.*;

import com.vhfc.cr.service.ProductosService;



@Controller
@RequestMapping(path = "/producto")
public class ProductosController {
	@Autowired
	private ProductosService productosService;
	

	@GetMapping()
	@ResponseBody
	public List<Producto> listarProducto() {
		return this.productosService.listarProductos();
	}

	@PostMapping()
	@ResponseBody
	public Producto agregarProducto(@RequestBody Producto producto) {
		return this.productosService.crearProductos(producto);
	}

	@DeleteMapping(path = "/{id}")
	public String eliminarProducto(@PathVariable("id") Long id) {
		boolean ok = productosService.borrarProductos(id);
		if (ok) {
			return "Se elimino el Producto Correctamente con id: " + id;
		} else {
			return "No se pudo eleimar el Producto con id: " + id;
		}
	}

	@GetMapping(path = "/{id}")
	@ResponseBody
	public Optional<Producto> buscarProducto(@PathVariable("id") Long id) {
		return productosService.buscarProductoPorId(id);
	}
	
	@GetMapping("/inicio")
	@ResponseBody
	public String inicio() {
		return "Iniciando sin security";
	}
	@GetMapping(path = "/inicio2")
	@ResponseBody
	public String inicioSecured() {
		return "Iniciando con security";
	}
}
