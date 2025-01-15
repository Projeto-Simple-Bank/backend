package com.avanade.simple_bank.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdmControllers {
	@GetMapping("/adm")
	public List<String> mostrarAdministradores(){
		List<String> administradores = new ArrayList<String>();
		administradores.add("Samira");
		administradores.add("Monica");
		administradores.add("Paula");
		
		return administradores;
	}
}
