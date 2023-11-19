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

import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/piezas")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/all")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
	
	
	@PostMapping("/add")
	public Pieza salvarPieza(@RequestBody Pieza pieza) {
		
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	
	@GetMapping("/{id}")
	public Pieza piezaXID(@PathVariable(name="id") Integer codigo) {
		
		Pieza Pieza_xid= new Pieza();
		
		Pieza_xid=piezaServiceImpl.piezaXID(codigo);
		
		return Pieza_xid;
	}
	
	@PutMapping("/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")Integer codigo,@RequestBody Pieza pieza) {
		
		Pieza Pieza_seleccionada= new Pieza();
		Pieza Pieza_actualizada= new Pieza();
		
		Pieza_seleccionada= piezaServiceImpl.piezaXID(codigo);
		
		Pieza_seleccionada.setNombre(pieza.getNombre());
		
		Pieza_actualizada = piezaServiceImpl.actualizarPieza(Pieza_seleccionada);
				
		return Pieza_actualizada;
	}
	
	@DeleteMapping("/{id}")
	public void eleiminarPieza(@PathVariable(name="id")Integer codigo) {
		piezaServiceImpl.eliminarPieza(codigo);
	}
}
