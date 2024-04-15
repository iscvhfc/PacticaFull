package com.vhfc.cr.repository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vhfc.cr.model.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Long>{
	

	public abstract ArrayList<Producto> findByCodigo(String codigo);
	
	
}
