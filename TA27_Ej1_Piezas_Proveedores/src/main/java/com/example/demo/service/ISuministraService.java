package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Suministra;

public interface ISuministraService {

	public List<Suministra> listarSuministros(); 
	
	public Suministra guardarSuministra(Suministra suministra);	
	
	public Suministra suministraXID(Integer id); 
	
	public Suministra actualizarSuministra(Suministra suministra); 
	
	public void eliminarSuministra(Integer id);
}
