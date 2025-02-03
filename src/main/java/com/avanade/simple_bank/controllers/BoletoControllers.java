package com.avanade.simple_bank.controllers;

import com.avanade.simple_bank.dto.BoletoDTO;
import com.avanade.simple_bank.entities.Boleto;
import com.avanade.simple_bank.services.BoletoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletos")
public class BoletoControllers {

	@Autowired
	private BoletoService boletoService;

	@GetMapping("/lista")
	public List<Boleto> listarBoletos() {
		return boletoService.listarBoletos();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Boleto> listarBoletoByCodigo(@PathVariable("codigo") String codigo) {
		try {
			return new ResponseEntity<Boleto>(
					boletoService.listarBoletoByCodigo(codigo), HttpStatus.OK);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping("/criar")
	public ResponseEntity<?> criarBoleto(@RequestBody Boleto boleto){
		try {
			return new ResponseEntity<Boleto>(
					boletoService.criarBoleto(boleto), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PostMapping("/pagar")
	public ResponseEntity<?> pagarBoleto(@RequestBody BoletoDTO boletoDTO){
		try {
			boletoService.pagarBoleto(boletoDTO);
			return new ResponseEntity<>(
					"Pagamento realizado com Sucesso!", HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
