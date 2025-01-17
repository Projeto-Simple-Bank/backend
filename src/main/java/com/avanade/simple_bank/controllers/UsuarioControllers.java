package com.avanade.simple_bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.entities.Usuario;
import com.avanade.simple_bank.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/lista")
	public ResponseEntity<List<Usuario>> listar() {
		return new ResponseEntity<List<Usuario>>(
				usuarioService.listarUsuarios(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Usuario>> buscarUsuariosByID(@PathVariable("id") String id) {
		return new ResponseEntity<List<Usuario>>(
				usuarioService.buscarUsuariosByID(id), HttpStatus.OK);
	}

	@PostMapping("/novo")
	public ResponseEntity<?> incluir(@RequestBody Usuario usuario){
		try {
			return new ResponseEntity<Usuario>(
					usuarioService.incluirUsuario(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
