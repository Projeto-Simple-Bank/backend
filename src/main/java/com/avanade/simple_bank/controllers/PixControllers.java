package com.avanade.simple_bank.controllers;

import com.avanade.simple_bank.entities.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.avanade.simple_bank.services.PixService;
import com.avanade.simple_bank.entities.Pix;

import java.util.List;

@RestController
@RequestMapping("/pix")
public class PixControllers {

	@Autowired
	private PixService pixService;

	@GetMapping("/lista")
	public List<Pix> listarPix() {
		return pixService.listarPix();
	}

	@PostMapping("/cadastrar-pix")
	public ResponseEntity<?> cadastrarPix(@RequestBody Pix pix){
		try {
			return new ResponseEntity<Pix>(
					pixService.cadastrarPix(pix), HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
