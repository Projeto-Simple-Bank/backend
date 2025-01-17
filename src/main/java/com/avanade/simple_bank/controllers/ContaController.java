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

import com.avanade.simple_bank.entities.Conta;
import com.avanade.simple_bank.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping("/lista")
    public List<Conta> listarContas() {
        return contaService.listarContas();
    }

    @PostMapping("/novo")
    public ResponseEntity<?> incluir(@RequestBody Conta conta){
        try {
            return new ResponseEntity<Conta>(
                    contaService.incluirConta(conta), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
