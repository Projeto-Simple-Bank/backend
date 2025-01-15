package com.avanade.simple_bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avanade.simple_bank.entities.Usuario;
import com.avanade.simple_bank.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControllers {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/lista")
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
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
