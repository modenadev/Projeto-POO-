📘 1. Introdução

Este projeto implementa um sistema de mensageria utilizando Spring Boot, RabbitMQ e Spring AMQP.
Ele foi desenvolvido como parte do plano de duas semanas para consolidar conhecimentos de:

Programação Orientada a Objetos

Arquitetura MVC

Spring Data JPA

APIs REST

Mensageria e comunicação assíncrona

RabbitMQ

Boas práticas de desenvolvimento

⚙️ 2. Objetivo Geral do Projeto

Criar um sistema funcional que utilize mensageria para processar pedidos e gerar notificações, mostrando domínio de:

✔ Envio e consumo de mensagens em filas RabbitMQ
✔ Comunicação assíncrona
✔ Integração entre camadas (Controller → Service → Repository → Messaging)
✔ Persistência com JPA
✔ Exposição de APIs RESTful

🧰 3. Tecnologias Utilizadas

Java 17

Spring Boot 3.3

Spring Web

Spring Data JPA

H2 Database

Spring AMQP (RabbitMQ)

RabbitMQ 4.x

Maven

VS Code

🏗️ 4. Arquitetura da Aplicação
src/main/java/com/example/mensageria
 ├── config
 ├── controller
 ├── dto
 ├── entity
 ├── messaging
 ├── repository
 ├── service
 └── MensageriaApplication.java

Fluxo de Mensageria
POST /pedidos
         ↓
PedidoService → PedidoProducer
         ↓
RabbitMQ Exchange → Queue
         ↓
PedidoConsumer
         ↓
Banco de Dados (Notificação gerada)

📦 5. Guia de Instalação
5.1 Pré-requisitos

Java 17+

Maven ou Maven Wrapper (./mvnw)

RabbitMQ instalado

VS Code ou IntelliJ

5.2 Instalando o RabbitMQ no Windows

Instalar Erlang OTP

Instalar RabbitMQ Server

Ativar painel de administração:

rabbitmq-plugins.bat enable rabbitmq_management


Rodar o servidor:

rabbitmq-server.bat


Acessar painel:

http://localhost:15672


(guest / guest)

▶️ 6. Como Rodar o Projeto
6.1 Rodar o back-end

No terminal:

./mvnw spring-boot:run


Ou clique em Run na classe MensageriaApplication.java.

O servidor sobe em:

http://localhost:8080

🧪 7. Guia de Uso (Testes da API)
Criar Pedido

POST /pedidos

{
  "clienteNome": "Ruan",
  "valorTotal": 120.00
}

Listar Pedidos

GET /pedidos

Listar Notificações

GET /notificacoes

Como funciona:

Você envia um pedido

Ele é salvo no banco

Uma mensagem é enviada ao RabbitMQ

O Consumer processa a mensagem

Uma notificação é criada automaticamente

📊 8. Resultados Obtidos

Sistema funcionando completamente

Fluxo de mensageria enviando e recebendo mensagens

RabbitMQ configurado com Exchange, Queue e Binding

APIs REST estáveis

Banco H2 acessível via /h2-console

Documentação e README completos

🧠 9. Principais Aprendizados

Como configurar e integrar RabbitMQ com Spring Boot

Diferença entre comunicação síncrona e assíncrona

Boas práticas de arquitetura em camadas

Criação de DTOs e uso de JPA

Injeção de dependência com Spring

Observação do comportamento real de filas

Diagnóstico de problemas (portas, configs, pacotes, beans)

⚠️ 10. Desafios Encontrados

Conflitos de porta com RabbitMQ

Problemas com configuração de pacotes (package)

Ajustes no application.yml para reconhecer propriedades

Falha ao iniciar a aplicação por placeholders não encontrados

Filas não sendo criadas por causa de pacotes fora do scan do Spring

(Esses desafios foram resolvidos durante o desenvolvimento.)

✔️ 11. Conclusão

O projeto demonstra domínio prático de:

Mensageria com RabbitMQ

Spring Boot + AMQP

Arquitetura limpa

API REST

Persistência com H2

Comunicação assíncrona

É um exemplo sólido para portfólio, apresentações e aprendizado.
