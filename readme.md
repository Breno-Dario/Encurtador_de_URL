# Encurtador de URLs

![Java](https://img.shields.io/badge/Java-17+-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)
![Build](https://img.shields.io/badge/Build-Passing-brightgreen)
![Tests](https://img.shields.io/badge/Tests-✔️-green)

Um serviço simples de **encurtamento de URLs** desenvolvido em **Java** com **Spring Boot**. Ele permite criar URLs curtas a partir de URLs longas e redirecionar automaticamente para a URL original.

---

## 💻 Tecnologias

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 Database** (ou outro banco relacional)
- **Maven** como gerenciador de dependências
- **Postman/cURL** para testes

---

## 🗂 Estrutura do Projeto

```bash
src/main/java/com/encutadorURL/encutadorURL/
│
├─ controller/UrlController.java # API REST
├─ dto/CreateUrlRequest.java # DTO para requisição de criação de URL
├─ model/Url.java # Entidade URL
├─ repository/UrlRepository.java # Repositório JPA
└─ service/UrlService.java # Lógica de negócio
```

---

## 🚀 Endpoints da API

### 1. Criar URL curta

**Request Body:**
```json
 # POST /api/urls

{
  "originalUrl": "https://exemplo.com/minha-url-longa"
}
```
**Response:**
```json
{
  "id": 1,
  "originalUrl": "https://exemplo.com/minha-url-longa",
  "shortCode": "a1b2c3",
  "createdAt": "2026-02-09T12:00:00"
}
```

### 2. Redirecionar para URL original
```bash
GET /api/urls/{shortCode}
```
**Exemplo:**
```bash
GET /api/urls/a1b2c3
```
*Resposta:* Redireciona automaticamente (HTTP 302) para a URL original.

---
## 🗃 Banco de Dados
O projeto usa H2 Database em memória por padrão. Para acessar o console H2:

- URL: http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:testdb
- User: sa
- Password: (vazio)

**Exemplo de configuração:**
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```
Caso queira troca pra outro banco de dados, basta alterar URL, driver usuário e senha.

---
## 💿 Como rodar

**1. Clone o repositório:**
```bash
git clone https://github.com/seu-usuario/encurtador-url.git
cd encurtador-url
```
**2. Compile e execute**
```bash
mvn clean install
mvn spring-boot:run
```

**3. Acesse a API em http://localhost:8080/api/urls.**

---
## ✅ Funcionalidade 

- Criação de URLs curtas a partir de URLs longas..
- Redirecionamento automático para URL original
- Código curto gerado automaticamente (6 caracteres)
- Persistência com Spring Data JPA
- Suporte para H2 em memória ou qualquer banco relacional

---
## 📷 Foto

<img width="1036" height="679" alt="image" src="https://github.com/user-attachments/assets/bf3cac5c-4519-4cb3-9053-7847f4a8ba14" />

<img width="924" height="297" alt="image" src="https://github.com/user-attachments/assets/35fe7c2b-9b9a-453d-8054-6eb18ecc019a" />

---
📄 Licensa
Este projeto está sob licença **MIT**.
