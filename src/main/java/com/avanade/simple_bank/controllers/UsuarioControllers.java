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
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}

	@PostMapping("/criar-usuario")
	public ResponseEntity<?> incluir(@RequestBody Usuario usuario){
		try {
			if(!usuario.getCpf().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
				throw new RuntimeException("CPF inválido");
			}
			if(!usuario.getRg().matches("\\d{1,2}\\.\\d{3}\\.\\d{3}-\\d{1}")){
				throw new RuntimeException("RG inválido");
			}
			return new ResponseEntity<Usuario>(
					usuarioService.incluirUsuario(usuario), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}