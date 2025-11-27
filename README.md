# 🎮 Games Rental

API para gerenciamento de locação de jogos.  
Projeto desenvolvido em Java com Spring Boot e Maven.

---

## ✅ Objetivo

Esta aplicação tem como objetivo gerenciar o catálogo de jogos e o processo de locação, permitindo:

- Cadastrar jogos
- Listar jogos disponíveis
- Atualizar informações de jogos
- Remover jogos
- Registrar locações e devoluções (conforme implementado no código)

---

## 🛠️ Tecnologias utilizadas

- **Java 17+** (ajuste se o seu `pom.xml` estiver com outra versão)
- **Spring Boot** (Web, Data JPA, Validation, etc.)
- **Maven**
- **Banco de dados**: H2 / MySQL / PostgreSQL (conforme configurado em `application.properties`)
- **Docker** (opcional, há um `Dockerfile` no projeto)

---

## 📁 Estrutura do projeto

Principais diretórios:

- `src/main/java`  
  - `.../controller` – classes de controller (endpoints REST)
  - `.../service` – regras de negócio
  - `.../repository` – interfaces de acesso ao banco (Spring Data JPA)
  - `.../model` ou `.../entity` – entidades (mapeamento JPA das tabelas)
  - `.../dto` – objetos de transferência de dados (se houver)
  - `GamesRentalApplication` – classe principal (`@SpringBootApplication`)

- `src/main/resources`
  - `application.properties` ou `application.yml` – configurações da aplicação
  - `data.sql` / `schema.sql` – scripts para popular o banco (se existirem)

---

## ▶️ Como rodar o projeto localmente

### 1. Pré-requisitos

- Java instalado (versão compatível com o projeto)
- Maven instalado **ou** usar o `mvnw`/`mvnw.cmd` que já vem no repositório
- Banco de dados em execução, se não for H2

### 2. Clonar o repositório

```bash

3. Configurar o banco

No arquivo src/main/resources/application.properties (ou application.yml), ajuste:

URL do banco

Usuário e senha

Dialeto / driver (MySQL, PostgreSQL, etc.)

Exemplo (MySQL):

spring.datasource.url=jdbc:mysql://localhost:3306/games_rental
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


4. Rodar com Maven
# usando Maven instalado
mvn spring-boot:run

# ou usando o wrapper no Windows
mvnw.cmd spring-boot:run

# ou no Linux/Mac
./mvnw spring-boot:run


A API deve subir, por padrão, em:

http://localhost:8080

🌐 Endpoints principais (ajuste para o que existe no seu código)
🎮 Jogos

Listar todos os jogos

GET /games

Buscar jogo por ID

GET /games/{id}

Cadastrar novo jogo

POST /games
Corpo (JSON):

{
  "title": "The Last of Us",
  "platform": "PS4",
  "genre": "Action",
  "dailyPrice": 9.90,
  "available": true
}


Atualizar jogo

PUT /games/{id}

Remover jogo

DELETE /games/{id}

📦 Locações (se implementado)

Registrar locação

POST /rentals

{
  "gameId": 1,
  "customerName": "Alex",
  "rentalDate": "2025-11-26",
  "returnDate": "2025-11-30"
}


Listar locações

GET /rentals

Registrar devolução

PUT /rentals/{id}/return

🧪 Testes

Se existirem testes configurados com JUnit/Mockito:

mvn test

🐳 Rodando com Docker (opcional)

Há um Dockerfile no projeto. Para criar a imagem:

docker build -t games-rental .


Rodar o container:

docker run -p 8080:8080 games-rental

👨‍💻 Autor

Alexsandro José da Silva
Marcos Regis da Silva
Gabriel Pimenta

GitHub: @Alexsandro793

📌 Melhorias futuras

Autenticação e autorização (Spring Security)

Documentação automática com Swagger / OpenAPI

Interface web para consumo da API

Relatórios de locações e faturamento

 clone https://github.com/Alexsandro793/Games-rental.git
cd Games-rental
