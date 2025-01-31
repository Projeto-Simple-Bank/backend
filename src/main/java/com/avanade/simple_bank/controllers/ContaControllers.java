package com.avanade.simple_bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.entities.Transacao;
import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.services.ContaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contas")
public class ContaControllers {

	@Autowired
	private ContaService contaService;
	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping("/lista")
	public List<Conta> listarConta() {
		return contaService.listarConta();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Conta> listarContaId(
			@PathVariable("id") int contaId  // obtém o id pela a url
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

// atualizacao do transacao na conta do cliente
//	@PostMapping("/saldo-atualizado/{id}")
//	public ResponseEntity<?> atualizarSaldo(
//			@PathVariable("id") int contaId,  // obtém o id pela a url
//			@RequestBody Transacao transacao) {
//
//		try {
//			Conta saldoAtualizado = contaService.atualizarSaldo(contaId, transacao);
//			return ResponseEntity.status(HttpStatus.CREATED).body(saldoAtualizado);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//	}

}
