📦 Sistema de Gerenciamento de Pedidos com Mensageria

Um sistema robusto para processamento assíncrono de pedidos e notificações utilizando arquitetura orientada a eventos.

📑 Índice

Sobre o Projeto

Arquitetura da Solução

Tecnologias Utilizadas

Pré-requisitos e Instalação

Como Executar

Documentação da API

Resultados e Aprendizados

📖 Sobre o Projeto

Este projeto foi desenvolvido para consolidar conhecimentos avançados em Programação Orientada a Objetos e Arquitetura de Software. O objetivo central é demonstrar a aplicação prática de mensageria assíncrona para desacoplar serviços críticos.

O sistema simula um e-commerce onde a criação de um pedido dispara automaticamente um processo de notificação, sem bloquear a resposta ao usuário final, garantindo maior performance e escalabilidade.

Objetivos Específicos

✔️ Implementar comunicação assíncrona com RabbitMQ.

✔️ Demonstrar o padrão Producer-Consumer.

✔️ Aplicar arquitetura em camadas (MVC).

✔️ Persistir dados relacionalmente com Spring Data JPA.

🏗 Arquitetura da Solução

O sistema segue uma arquitetura baseada em microsserviços lógicos, onde o fluxo de dados é gerenciado através de filas.

Fluxo de Mensageria

sequenceDiagram
    participant Cliente
    participant PedidoService
    participant RabbitMQ
    participant Consumer
    participant BancoDados

    Cliente->>PedidoService: POST /pedidos (Cria Pedido)
    PedidoService->>BancoDados: Salva Pedido (Status: Pendente)
    PedidoService->>RabbitMQ: Envia Mensagem (PedidoMessageDTO)
    RabbitMQ-->>PedidoService: Ack
    PedidoService-->>Cliente: 201 Created (Imediato)
    
    loop Processamento Assíncrono
        RabbitMQ->>Consumer: Entrega Mensagem
        Consumer->>BancoDados: Gera Notificação
        Consumer->>BancoDados: Atualiza Status Pedido
    end


Estrutura de Pacotes

src/main/java/com/example/mensageria

├── config          # Configurações do RabbitMQ (Exchanges, Queues)

├── controller      # Endpoints REST

├── dto             # Objetos de Transferência de Dados (Records/Class)

├── entity          # Entidades JPA (Banco de Dados)

├── messaging       # Producers e Consumers

├── repository      # Interfaces Spring Data

└── service         # Regras de Negócio



🛠 Tecnologias Utilizadas

Java 17

Framework

Spring Boot 3.3 (Web, Data JPA, AMQP)

Mensageria

RabbitMQ 4.x (Protocolo AMQP)

Banco de Dados

H2 Database (Em memória)

Build Tool

Maven

IDE

VS Code / IntelliJ IDEA

📦 Pré-requisitos e Instalação

Antes de começar, certifique-se de ter o ambiente configurado:

1. Pré-requisitos

Java JDK 17+

RabbitMQ Server (Instalado localmente ou via Docker)

Maven

2. Configuração do RabbitMQ (Windows/Linux)

Se estiver usando Docker (Recomendado):

docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management


Instalação Manual (Windows):

Instale o Erlang OTP.

Instale o RabbitMQ Server.

Ative o painel de gestão:

rabbitmq-plugins.bat enable rabbitmq_management


Inicie o servidor:

rabbitmq-server.bat


Acesso: http://localhost:15672 (User: guest / Pass: guest)

▶️ Como Executar

Clone o repositório:

git clone [https://github.com/seu-usuario/projeto-mensageria.git](https://github.com/seu-usuario/projeto-mensageria.git)


Navegue até a pasta do projeto e instale as dependências:

./mvnw clean install


Execute a aplicação:

./mvnw spring-boot:run


O servidor iniciará em http://localhost:8080.

🧪 Documentação da API

1. Criar Novo Pedido

Envia um pedido para processamento e dispara a mensagem para a fila.

URL: /pedidos

Método: POST

Body:

{
  "clienteNome": "Ruan",
  "valorTotal": 120.50
}


2. Listar Pedidos

Retorna todos os pedidos cadastrados.

URL: /pedidos

Método: GET

3. Listar Notificações

Verifica as notificações geradas pelo consumidor após o processamento da fila.

URL: /notificacoes

Método: GET

🧠 Resultados e Aprendizados

Principais Conquistas

Configuração completa de Exchange, Queue e Binding no Spring Boot.

Implementação bem-sucedida de DTOs para tráfego seguro de dados.

Diagnóstico e resolução de conflitos de portas e injeção de dependências.

Desafios Superados

⚠️ Configuração de Pacotes: Inicialmente, as filas não eram criadas devido ao escaneamento incorreto dos pacotes pelo Spring. Solucionado reorganizando a estrutura de diretórios.

⚠️ Conexão AMQP: Ajustes finos foram necessários no application.yml para garantir a conexão estável com o RabbitMQ.

🤝 Contribuição

Este projeto é de cunho educacional. Sugestões e pull requests são bem-vindos!


