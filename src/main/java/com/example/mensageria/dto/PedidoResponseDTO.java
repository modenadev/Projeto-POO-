package com.example.mensageria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoResponseDTO {

    private Long id;
    private String clienteNome;
    private BigDecimal valorTotal;
    private String status;
    private LocalDateTime dataCriacao;

    public PedidoResponseDTO(Long id, String clienteNome, BigDecimal valorTotal,
                             String status, LocalDateTime dataCriacao) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
