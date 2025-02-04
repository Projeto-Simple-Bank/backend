package com.avanade.simple_bank.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.avanade.simple_bank.entities.Conta;
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

	@PutMapping("/editar-cliente")
	public ResponseEntity<?> editarUsuarioCliente(@PathVariable("id") UUID clienteId, @RequestBody Usuario cliente){
		try {
			return new ResponseEntity<>(
					adminService.editarUsuarioCliente(clienteId, cliente), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Administrador administrador) {
		Optional<Administrador> adminAutenticado = adminService.autenticar(administrador.getEmail(), administrador.getSenha());

		Map<String, Object> response = new HashMap<>();

		if (adminAutenticado.isPresent()) {
			response.put("message", "Login bem-sucedido!");
			response.put("id", adminAutenticado.get().getId()); // Retorna o ID da conta logada

			return ResponseEntity.ok(response);
		} else {
			response.put("error", "Credenciais inválidas.");
			return ResponseEntity.status(401).body(response);
		}
	}
}
