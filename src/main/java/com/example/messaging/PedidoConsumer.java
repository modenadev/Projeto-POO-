package com.example.messaging;

import com.example.dto.PedidoMessageDTO;
import com.example.entity.Notificacao;
import com.example.service.NotificacaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PedidoConsumer {

    private final NotificacaoService notificacaoService;

    @Value("${app.notificacao.tipo:EMAIL}")
    private String tipoNotificacao;

    public PedidoConsumer(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void processarPedidoCriado(PedidoMessageDTO mensagem) {
        try {
            System.out.println("Processando pedido " + mensagem.getId()
                    + " para cliente " + mensagem.getClienteNome());

            Notificacao notificacao = new Notificacao(
                    mensagem.getId(),
                    tipoNotificacao,
                    "PROCESSADA",
                    LocalDateTime.now(),
                    null
            );

            notificacaoService.salvar(notificacao);
        } catch (Exception e) {
            Notificacao notificacaoErro = new Notificacao(
                    mensagem.getId(),
                    tipoNotificacao,
                    "ERRO",
                    LocalDateTime.now(),
                    e.getMessage()
            );
            notificacaoService.salvar(notificacaoErro);
        }
    }
}
