package com.example.mensageria.service;

import com.example.mensageria.entity.Notificacao;
import com.example.mensageria.repository.NotificacaoRepository;
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
