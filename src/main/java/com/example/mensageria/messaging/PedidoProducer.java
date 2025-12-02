package com.example.mensageria.messaging;

import com.example.mensageria.dto.PedidoMessageDTO;
import com.example.mensageria.entity.Pedido;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange}")
    private String exchange;

    @Value("${app.rabbitmq.routing-key}")
    private String routingKey;

    public PedidoProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarPedidoCriado(Pedido pedido) {
        PedidoMessageDTO mensagem = new PedidoMessageDTO(
                pedido.getId(),
                pedido.getClienteNome(),
                pedido.getValorTotal(),
                pedido.getStatus(),
                pedido.getDataCriacao()
        );

        rabbitTemplate.convertAndSend(exchange, routingKey, mensagem);
    }
}
