package com.avanade.simple_bank.controllers;

import com.avanade.simple_bank.entities.Boleto;
import com.avanade.simple_bank.services.BoletoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boletos")
public class BoletoControllers {

	@Autowired
	private BoletoService boletoService;

	@PostMapping("/criar")
	public ResponseEntity<?> criarBoleto(@RequestBody Boleto boleto){
		try {
			return new ResponseEntity<Boleto>(
					boletoService.criarBoleto(boleto), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/pagar-boleto")
	public ResponseEntity<?> pagarBoleto(Boleto boleto){
		try {
			boletoService.pagarBoleto(boleto);
			return new ResponseEntity<>("Pagamento realizado com Sucesso!", HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
