package com.avanade.simple_bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.entities.Transacao;
import com.avanade.simple_bank.repositories.TransacaoRepository;
import com.avanade.simple_bank.services.ContaService;

import java.util.List;

@RestController
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

}
