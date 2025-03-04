package com.vhfc.cr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vhfc.cr.model.Producto;
import com.vhfc.cr.repository.ProductosRepository;

@Service
public class ProductosService {
	@Autowired
	ProductosRepository productosRepo;
	public Producto crearProductos(Producto producto) {
		return productosRepo.save(producto);
	}
	public List<Producto> listarProductos() {
		return productosRepo.findAll();
	}
	
	public boolean borrarProductos(Long id) {
		try {
			productosRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	public Optional <Producto>buscarProductoPorId (Long Id) {
		return productosRepo.findById(Id);
	}
	
	public ArrayList<Producto> obtenerPorCodigo(String codigo){
		return productosRepo.findByCodigo(codigo);
	}
	
	
}
