package com.avanade.simple_bank.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.entities.Administrador;
import com.avanade.simple_bank.services.AdministradorService;

@RestController
@RequestMapping("/administradores")
public class AdministradorControllers {

	@Autowired
	private AdministradorService administradorService;

	@GetMapping("/lista")
	public List<Administrador> listarAdmin() {
		return administradorService.listarAdmin();
	}

	@PostMapping("/criar-admin")
	public ResponseEntity<?> criarAdmin(@RequestBody Administrador administrador){
		try {
			return new ResponseEntity<Administrador>(
					administradorService.criarAdmin(administrador), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
