package com.example.service;

import com.example.entity.Notificacao;
import com.example.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    @Transactional(readOnly = true)
    public List<Notificacao> listarTodas() {
        return notificacaoRepository.findAll();
    }

    @Transactional
    public Notificacao salvar(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }
}
