package com.avanade.simple_bank.controllers;

import com.avanade.simple_bank.dto.TransacaoDTO;
import com.avanade.simple_bank.entities.Conta;
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

    @GetMapping("/{id-conta}")
    public ResponseEntity<List<Transacao>> listarTransacoes(@PathVariable("id-conta") Conta conta) {
        try {
            return new ResponseEntity<List<Transacao>>(
                    transacaoService.listarTransacoes(conta), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/efetuar-pagamento")
    public ResponseEntity<?> efetuarPagamento(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            transacaoService.efetuarPagamento(transacaoDTO);
            return new ResponseEntity<>(
                    "Pagamento realizado com Sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
