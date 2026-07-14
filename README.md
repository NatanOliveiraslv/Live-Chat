# Live Chat MS

Aplicação de chat em tempo real construída com **Spring Boot** e **WebSocket (STOMP)**, com front-end simples em HTML/CSS/JavaScript.

## ✨ Funcionalidades

- Comunicação em tempo real via WebSocket usando o protocolo STOMP
- Broker de mensagens simples integrado ao Spring
- Escape de HTML nas mensagens para prevenir XSS
- Interface web para conectar, desconectar e enviar mensagens no chat

## 🛠️ Tecnologias utilizadas

**Back-end**
- Java
- Spring Boot
- Spring WebSocket / STOMP messaging

**Front-end**
- HTML5 / CSS3
- JavaScript (jQuery)
- [@stomp/stompjs](https://github.com/stomp-js/stompjs) (cliente STOMP)
- Bootstrap 3

## 📁 Estrutura do projeto

```
src/main/java/com/br/livechatms
├── LivechatmsApplication.java      # Classe principal (entry point)
├── config
│   └── WebSocketConfig.java        # Configuração do broker WebSocket/STOMP
├── controller
│   └── LiveChatController.java     # Endpoint de mensagens (@MessageMapping)
└── domain
    ├── ChatInput.java              # Record de entrada (user, message)
    └── ChatOutput.java             # Record de saída (content)

src/main/resources/static
├── index.html                      # Página do chat
├── app.js                          # Lógica do cliente STOMP
└── main.css                        # Estilos da interface
```

## ⚙️ Como funciona

1. O front-end se conecta ao endpoint WebSocket `/buildrun-livechat-websocket`.
2. Ao enviar uma mensagem, o cliente publica em `/app/new-message`.
3. O `LiveChatController` recebe a mensagem (`ChatInput`), escapa o conteúdo HTML e retorna um `ChatOutput`.
4. A mensagem processada é distribuída a todos os clientes inscritos em `/topics/livechat`.

```
Cliente ──(publish)──▶ /app/new-message ──▶ LiveChatController ──(broadcast)──▶ /topics/livechat ──▶ Todos os clientes
```

## 🚀 Como executar

### Pré-requisitos

- Java 17+ (ou versão compatível com o Spring Boot utilizado no projeto)
- Maven (ou o wrapper `mvnw` incluso no projeto)

### Passos

```bash
# Clone o repositório
git clone <url-do-repositorio>
cd live-chat-java

# Execute a aplicação
./mvnw spring-boot:run
```

A aplicação estará disponível em:

```
http://localhost:8080
```

## 💬 Usando o chat

1. Acesse `http://localhost:8080` no navegador.
2. Informe um **username**.
3. Clique em **Connect** para abrir a conexão WebSocket.
4. Digite uma mensagem e clique em **Send**.
5. As mensagens enviadas por todos os usuários conectados aparecem em tempo real na tabela do chat.
6. Clique em **Disconnect** para encerrar a conexão.

## 📌 Possíveis melhorias futuras

- Persistência de mensagens em banco de dados
- Autenticação de usuários
- Salas de chat separadas por tópico
- Indicador de usuários online
- Suporte a mensagens privadas

## 📄 Licença

Este projeto está disponível livremente para fins de estudo. Ajuste esta seção conforme a licença desejada.