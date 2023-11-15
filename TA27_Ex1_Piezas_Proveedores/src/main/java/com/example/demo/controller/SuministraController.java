package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	@GetMapping("/suministras")
	public List<Suministra> listarProveedores(){
		return suministraServiceImpl.listarSuministros();
	}
	
	
	@PostMapping("/suministras")
	public Suministra salvarProveedor(@RequestBody Suministra suministra) {
		
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	
	@GetMapping("/suministras/{id}")
	public Suministra proveedorXID(@PathVariable(name="id") Integer id) {
		
		Suministra suministra_xid= new Suministra();
		
		suministra_xid = suministraServiceImpl.suministraXID(id);
		
		return suministra_xid;
	}
	
	@PutMapping("/suministras/{codigo}")
	public Suministra actualizarProveedor(@PathVariable(name="id")Integer id,@RequestBody Suministra suministra) {
		
		Suministra Suministra_seleccionada= new Suministra();
		Suministra Suministra_actualizada= new Suministra();
		
		Suministra_seleccionada= suministraServiceImpl.suministraXID(id);
		
		Suministra_seleccionada.setPieza(suministra.getPieza());
		Suministra_seleccionada.setProveedor(suministra.getProveedor());
		
		Suministra_actualizada = suministraServiceImpl.actualizarSuministra(Suministra_seleccionada);
				
		return Suministra_actualizada;
	}
	
	@DeleteMapping("/suministras/{id}")
	public void eliminarProveedor(@PathVariable(name="id")Integer id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
}
