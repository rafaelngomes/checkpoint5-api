# 📦 Checkpoint 5 — API Spring Boot (Docker & Compose)

> Projeto desenvolvido em **Java com Spring Boot**, com o objetivo de reforçar os conceitos de **API REST**, **camadas de aplicação**, **validação de dados**, **testes automatizados** e **containerização com Docker e Docker Compose**.

[![Java 17](https://img.shields.io/badge/Java-17+-red)]() [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)]() [![Maven](https://img.shields.io/badge/Maven-3.9+-blue)]() [![Docker](https://img.shields.io/badge/Docker-24+-informational)]()

---

## 👥 Integrantes

* **Rafael Nascimento Gomes** – RM 550843  
* **Rafael Arcoverde Melo** – RM 550206  

---


## ✨ Objetivo

Consolidar os conceitos aprendidos sobre:
* Desenvolvimento de **APIs REST** com o **Spring Boot**.  
* Implementação de **camadas lógicas organizadas** (Controller → Service → Repository).  
* Aplicação de **validações**, **tratamento de erros** e **testes unitários**.  
* **Empacotamento e orquestração** da aplicação utilizando Docker e Docker Compose.

---

## 🧰 Tecnologias

* **Linguagem:** Java 17+  
* **Framework:** Spring Boot (Web, Validation, Data JPA, Actuator)  
* **Documentação:** Swagger (springdoc-openapi)  
* **Banco de Dados:** H2 (dev) / PostgreSQL (docker)  
* **Gerenciador de Build:** Maven  
* **Containerização:** Docker e Docker Compose  

---

## ✅ Pré-requisitos

Antes de executar o projeto, garanta que possui instalado:
* **JDK 17+**  
* **Maven 3.9+** (ou utilize `mvnw`)  
* **Docker 24+** e **Docker Compose**

---

## ▶️ Execução Local

1. **Clonar o repositório**
```bash
git clone https://github.com/rafaelngomes/checkpoint5-api.git
cd checkpoint5-api
````

2. **Executar com Maven (perfil `dev`)**

```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

3. **Acessos disponíveis**

* Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* Console H2 (opcional): [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🐳 Execução via Docker

**Gerar a imagem Docker**

```bash
docker build -t rafaelngomes/checkpoint-5:latest .
```

**Executar o container**

```bash
docker run --rm -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=docker \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/appdb \
  -e SPRING_DATASOURCE_USERNAME=app \
  -e SPRING_DATASOURCE_PASSWORD=app123 \
  rafaelngomes/checkpoint-5:latest
```


## 🧩 Execução via Docker Compose

**Exemplo de `docker-compose.yml`**

```yaml
services:
  db:
    image: postgres:16
    environment:
      POSTGRES_DB: appdb
      POSTGRES_USER: app
      POSTGRES_PASSWORD: app123
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

  api:
    image: rafaelngomes/checkpoint-5:latest
    depends_on:
      - db
    environment:
      SPRING_PROFILES_ACTIVE: docker
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/appdb
      SPRING_DATASOURCE_USERNAME: app
      SPRING_DATASOURCE_PASSWORD: app123
    ports:
      - "8080:8080"

volumes:
  pgdata:
```

**Comandos principais**

```bash
docker compose up -d --build
docker compose logs -f api
docker compose down
```

---

## ⚙️ Configurações (.env / perfis)

**Exemplo de `.env`**

```env
SPRING_PROFILES_ACTIVE=dev
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/checkpoint
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

**Perfis disponíveis**

* `dev` — ambiente de desenvolvimento (com H2).
* `docker` — ambiente containerizado com PostgreSQL.

---

## 📚 Swagger e Consoles

* **Swagger UI:**
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
  ou
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

* **H2 Console:**
  [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---



## ☁️ Publicação no Docker Hub

```bash
docker login
docker tag rafaelngomes/checkpoint-5:latest rafaelngomes/checkpoint-5:1.0.0
docker push rafaelngomes/checkpoint-5:1.0.0
docker push rafaelngomes/checkpoint-5:latest
```

**Repositório Docker Hub:**
🔗 [https://hub.docker.com/repository/docker/rafaelngomes/checkpoint-5](https://hub.docker.com/repository/docker/rafaelngomes/checkpoint-5)

---

## 🛠️ Comandos Úteis do Docker

```bash
docker ps -a
docker stop $(docker ps -aq)
docker rm $(docker ps -aq)
docker rmi $(docker images -q)
docker system prune -af
docker volume prune -f
```

---

## 🚀 CI/CD & Release

### Branches

* `main` — versão estável
* `develop` — desenvolvimento
* `feature/*` — novas funcionalidades
* `hotfix/*` — correções rápidas

