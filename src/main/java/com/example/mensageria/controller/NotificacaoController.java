package com.example.mensageria.controller;

import com.example.mensageria.entity.Notificacao;
import com.example.mensageria.service.NotificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Notificacao>> listarTodas() {
        return ResponseEntity.ok(notificacaoService.listarTodas());
    }
}
