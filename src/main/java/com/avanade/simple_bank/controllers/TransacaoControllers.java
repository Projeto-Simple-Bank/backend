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
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/transacoes")
public class TransacaoControllers {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("/listar/{id-conta}")
    public ResponseEntity<List<Transacao>> listarTransacoes(@PathVariable("id-conta") Conta conta) {
        try {
            return new ResponseEntity<List<Transacao>>(
                    transacaoService.listarTransacoes(conta), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id-transacao}")
    public ResponseEntity<Transacao> listarTransacaoPorId(@PathVariable("id-transacao") Transacao transacao) {
        try {
            return new ResponseEntity<Transacao>(
                    transacaoService.listarTransacaoPorId(transacao), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/efetuar-pagamento")
    public ResponseEntity<?> efetuarPagamento(@RequestBody TransacaoDTO transacaoDTO) {
        try {
            UUID transacaoId = transacaoService.efetuarPagamento(transacaoDTO);
            return new ResponseEntity<>(Map.of("message", "Pagamento realizado com Sucesso!", "transacaoId", transacaoId), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
