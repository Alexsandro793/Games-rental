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
git clone https://github.com/Alexsandro793/Games-rental.git
cd Games-rental
