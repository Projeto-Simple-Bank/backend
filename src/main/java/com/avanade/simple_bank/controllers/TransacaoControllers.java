package com.avanade.simple_bank.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.entities.Transacao;
import com.avanade.simple_bank.services.TransacaoService;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoControllers {

	@Autowired
	private TransacaoService transacaoService;

	@GetMapping("/lista")
	public List<Transacao> listarTransacao() {
		return transacaoService.listarTransacao();
	}

	@PostMapping("/efetuar-transacao")
	public ResponseEntity<?> efetuarTransacao(@RequestBody Transacao transacao){
		try {
			return new ResponseEntity<Transacao>(
					transacaoService.efetuarTransacao(transacao), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
