package com.avanade.simple_bank.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllers {
	
	@GetMapping("/usuarios")
	public List<String> mostrarUsuarios(){
		List<String> usuarios = new ArrayList<String>();
		usuarios.add("Samira");
		usuarios.add("Monica");
		usuarios.add("Paula");
		
		return usuarios;
	}
	
	@GetMapping("/usuarios/:id")
	public List<String> encontrarUsuarioID(int id){
		List<String> usuario = new ArrayList<String>();
		
		return usuario;
	}
}
