package com.avanade.simple_bank.controllers;

import java.util.List;
import java.util.UUID;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.entities.Usuario;
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
	private AdministradorService adminService;

	@GetMapping("/lista")
	public List<Administrador> listarAdmin() {
		return adminService.listarAdmin();
	}

	@PostMapping("/criar-admin")
	public ResponseEntity<?> criarAdmin(@RequestBody Administrador administrador){
		try {
			return new ResponseEntity<Administrador>(
					adminService.criarAdmin(administrador), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping("/editar-cliente/{id}")
	public ResponseEntity<?> editarUsuarioCliente(@PathVariable("id") UUID clienteId, @RequestBody Usuario cliente){
		try {
			return new ResponseEntity<>(
					adminService.editarUsuarioCliente(clienteId, cliente), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
