package com.example.mensageria.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificacoes")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String tipo; // ex: EMAIL

    @Column(nullable = false)
    private String status; // PROCESSADA / ERRO

    @Column(name = "data_processamento", nullable = false)
    private LocalDateTime dataProcessamento;

    @Column(name = "mensagem_erro", length = 1000)
    private String mensagemErro;

    public Notificacao() {
    }

    public Notificacao(Long pedidoId, String tipo, String status,
                       LocalDateTime dataProcessamento, String mensagemErro) {
        this.pedidoId = pedidoId;
        this.tipo = tipo;
        this.status = status;
        this.dataProcessamento = dataProcessamento;
        this.mensagemErro = mensagemErro;
    }

    public Long getId() {
        return id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(LocalDateTime dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }
}
