package com.avanade.simple_bank.controllers;

import com.avanade.simple_bank.repositories.ContaRepository;
import com.avanade.simple_bank.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.services.ContaService;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaControllers {

	@Autowired
	private ContaService contaService;
	private UsuarioRepository usuarioRepository;
	private ContaRepository contaRepository;

	@GetMapping("/lista")
	public List<Conta> listarContas() {
		return contaService.listarContas();
	}

	@GetMapping("/numero-conta/{conta}")
	public ResponseEntity<Conta> listarNumeroConta(@PathVariable("conta") String numeroConta) {
		try {
			return new ResponseEntity<Conta>(
					contaService.listarNumeroConta(numeroConta), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Conta> listarContaId(
			@PathVariable("id") UUID contaId  // obtém o id pela a url
	) {
		try {
			return new ResponseEntity<Conta>(
					contaService.listarContaId(contaId), HttpStatus.OK);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping("/criar-conta")
	public ResponseEntity<?> criarConta(@RequestBody Conta conta){
		try {
			return new ResponseEntity<Conta>(
					contaService.criarConta(conta), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Conta conta) {
		Optional<Conta> contaAutenticada = contaService.autenticar(conta.getConta(), conta.getSenha());

		Map<String, Object> response = new HashMap<>();

		if (contaAutenticada.isPresent()) {
			response.put("message", "Login bem-sucedido!");
			response.put("id", contaAutenticada.get().getId()); // Retorna o ID da conta logada

			return ResponseEntity.ok(response);
		} else {
			response.put("error", "Credenciais inválidas.");
			return ResponseEntity.status(401).body(response);
		}
	}

}
