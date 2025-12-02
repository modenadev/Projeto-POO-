package com.example.service;

import com.example.dto.PedidoRequestDTO;
import com.example.dto.PedidoResponseDTO;
import com.example.entity.Pedido;
import com.example.messaging.PedidoProducer;
import com.example.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoProducer pedidoProducer;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoProducer pedidoProducer) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoProducer = pedidoProducer;
    }

    @Transactional
    public PedidoResponseDTO criarPedido(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setClienteNome(dto.getClienteNome());
        pedido.setValorTotal(dto.getValorTotal());
        pedido.setStatus("CRIADO");
        pedido.setDataCriacao(LocalDateTime.now());

        Pedido salvo = pedidoRepository.save(pedido);

        pedidoProducer.enviarPedidoCriado(salvo);

        return new PedidoResponseDTO(
                salvo.getId(),
                salvo.getClienteNome(),
                salvo.getValorTotal(),
                salvo.getStatus(),
                salvo.getDataCriacao()
        );
    }

    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> listarPedidos() {
        return pedidoRepository.findAll().stream()
                .map(p -> new PedidoResponseDTO(
                        p.getId(),
                        p.getClienteNome(),
                        p.getValorTotal(),
                        p.getStatus(),
                        p.getDataCriacao()
                ))
                .toList();
    }
}
