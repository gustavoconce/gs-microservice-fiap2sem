# GS Microservice — FIAP

Microserviço REST desenvolvido como **projeto acadêmico/prova da FIAP**, durante o segundo semestre, com o objetivo de aplicar conceitos de desenvolvimento de APIs, arquitetura em camadas, persistência de dados e operações CRUD utilizando Java e Spring Boot.

O projeto implementa uma API para gerenciamento de **eletrônicos**, permitindo cadastrar, consultar, atualizar e excluir registros.

---

## 📚 Sobre o projeto

Este repositório contém a implementação de uma **Global Solution da FIAP — Microservice 2º Semestre**.

A aplicação foi desenvolvida utilizando Spring Boot e segue uma organização em camadas, separando as responsabilidades entre:

* Controller;
* Service;
* Repository;
* Model;
* DTOs;
* Mapper;
* Configuração.

O recurso principal da aplicação é o gerenciamento de eletrônicos, representado pela entidade `Eletronicos`.

Cada eletrônico possui informações como:

* Nome;
* Modelo;
* Consumo;
* Quantidade.

A API disponibiliza operações de criação, consulta, atualização, exclusão e busca por nome.

---

## 🎯 Objetivo acadêmico

O projeto teve como objetivo colocar em prática conceitos relacionados ao desenvolvimento de microserviços e APIs REST utilizando o ecossistema Java/Spring.

Entre os principais conceitos trabalhados estão:

* Desenvolvimento de APIs REST;
* Spring Boot;
* Spring Web;
* Spring Data JPA;
* Hibernate/JPA;
* Arquitetura em camadas;
* DTOs;
* Mapeamento entre objetos;
* ModelMapper;
* Injeção de dependências;
* Operações CRUD;
* Persistência de dados;
* Testes com Spring Boot.

---

## 🛠️ Tecnologias utilizadas

| Tecnologia               | Utilização                            |
| ------------------------ | ------------------------------------- |
| Java 23                  | Linguagem principal                   |
| Spring Boot 3.4.0        | Framework da aplicação                |
| Spring Web               | Desenvolvimento da API REST           |
| Spring Data JPA          | Persistência e acesso aos dados       |
| JPA / Hibernate          | Mapeamento objeto-relacional          |
| ModelMapper 3.2.1        | Conversão entre DTOs e entidades      |
| Lombok                   | Redução de código boilerplate         |
| Maven                    | Gerenciamento de dependências e build |
| Spring Boot DevTools     | Facilitação do desenvolvimento        |
| JUnit / Spring Boot Test | Estrutura de testes                   |

As versões utilizadas estão definidas no `pom.xml` do projeto.

---

# 🏗️ Arquitetura

A aplicação utiliza uma arquitetura em camadas:

```text
┌──────────────────────────────┐
│          Controller          │
│     Requisições HTTP         │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│           Service            │
│      Regras da aplicação     │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│         Repository           │
│       Acesso aos dados       │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│        Banco de dados        │
│        via JPA/Hibernate     │
└──────────────────────────────┘
```

O `Controller` recebe as requisições HTTP, o `Service` centraliza as operações da aplicação e o `Repository` utiliza o Spring Data JPA para persistência.

---

# 📁 Estrutura do projeto

```text
gs-microservice-fiap2sem/
├── .mvn/
│   └── wrapper/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── fiap/
│   │   │           └── gsmicroservice/
│   │   │               ├── config/
│   │   │               │   └── ModelMapperConfig.java
│   │   │               │
│   │   │               ├── controller/
│   │   │               │   └── EletronicoController.java
│   │   │               │
│   │   │               ├── dtos/
│   │   │               │   ├── EletronicoRequestCreateDto.java
│   │   │               │   ├── EletronicoRequestUptadeDto.java
│   │   │               │   └── EletronicoResponseDto.java
│   │   │               │
│   │   │               ├── mapper/
│   │   │               │   └── EletronicoMapper.java
│   │   │               │
│   │   │               ├── model/
│   │   │               │   └── Eletronicos.java
│   │   │               │
│   │   │               ├── repository/
│   │   │               │   └── EletronicoRepository.java
│   │   │               │
│   │   │               ├── service/
│   │   │               │   └── EletronicoService.java
│   │   │               │
│   │   │               └── GsmicroserviceApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── fiap/
│                   └── gsmicroservice/
│                       └── GsmicroserviceApplicationTests.java
│
├── .gitattributes
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

A estrutura atual do projeto possui pacotes separados para configuração, controller, DTOs, mapper, model, repository e service.

---

# 🧩 Componentes principais

## Controller

O `EletronicoController` é responsável por expor os endpoints REST da aplicação.

O controller está mapeado para:

```http
/eletronicos
```

e disponibiliza operações para:

* Listar eletrônicos;
* Buscar eletrônico por ID;
* Buscar eletrônico por nome;
* Cadastrar eletrônico;
* Atualizar eletrônico;
* Excluir eletrônico.

---

## Service

A classe `EletronicoService` concentra as operações relacionadas aos eletrônicos.

Entre seus métodos estão:

```text
list()
findById()
findByNome()
save()
existsById()
delete()
```

O Service utiliza `EletronicoRepository` para realizar as operações de persistência.

---

## Repository

O `EletronicoRepository` estende:

```java
JpaRepository<Eletronicos, Long>
```

Com isso, o Spring Data JPA disponibiliza automaticamente operações como:

* `findAll()`;
* `findById()`;
* `save()`;
* `existsById()`;
* `deleteById()`.

Também existe uma consulta derivada para busca por nome:

```java
findByNome(String nome)
```

---

# 📦 Model

A entidade principal do projeto é `Eletronicos`.

Ela é marcada com:

```java
@Entity
```

e possui geração automática do identificador utilizando JPA.

### Atributos

| Campo        | Tipo     | Descrição                   |
| ------------ | -------- | --------------------------- |
| `id`         | `Long`   | Identificador do eletrônico |
| `nome`       | `String` | Nome do eletrônico          |
| `modelo`     | `String` | Modelo do eletrônico        |
| `consumo`    | `int`    | Consumo do eletrônico       |
| `quantidade` | `int`    | Quantidade disponível       |

Os campos `nome` e `modelo` possuem limite de 60 caracteres definido por `@Column(length = 60)`.

---

# 📦 DTOs

O projeto utiliza DTOs para separar os objetos utilizados nas requisições dos objetos utilizados pela persistência.

## `EletronicoRequestCreateDto`

Representa os dados recebidos durante o cadastro.

```json
{
  "consumo": 150,
  "modelo": "Modelo X",
  "nome": "Televisão",
  "quantidade": 10
}
```

Campos:

```text
consumo
modelo
nome
quantidade
```

---

## `EletronicoRequestUptadeDto`

Utilizado para receber os dados enviados durante uma atualização.

O projeto mantém esse DTO separado do DTO de criação, permitindo representar diferentes contratos de entrada para cada operação.

---

## `EletronicoResponseDto`

Representa os dados retornados pela API.

Campos:

```text
id
nome
modelo
consumo
quantidade
```

---

# 🔄 ModelMapper

O projeto utiliza o **ModelMapper** para realizar a conversão entre DTOs e entidades.

A classe `EletronicoMapper` disponibiliza métodos para:

```text
Entity → Response DTO
Create DTO → Entity
Update DTO → Entity
```

Isso evita que a conversão dos objetos fique diretamente dentro do Controller.

A configuração do ModelMapper utiliza a estratégia:

```java
MatchingStrategies.STRICT
```

fazendo com que o mapeamento automático seja mais restritivo e baseado na correspondência explícita entre propriedades.

---

# 🌐 Endpoints

A API utiliza o prefixo:

```http
/eletronicos
```

## Listar eletrônicos

```http
GET /eletronicos
```

Retorna todos os eletrônicos cadastrados.

### Exemplo de resposta

```json
[
  {
    "id": 1,
    "nome": "Televisão",
    "modelo": "Smart TV",
    "consumo": 150,
    "quantidade": 10
  }
]
```

---

## Buscar por ID

```http
GET /eletronicos/{id}
```

Exemplo:

```http
GET /eletronicos/1
```

Caso o ID não exista, a aplicação lança uma exceção com a mensagem:

```text
Id inexistente
```

---

## Buscar por nome

```http
GET /eletronicos/find?nome=Televisão
```

O endpoint utiliza o método `findByNome()` do repository para realizar a consulta.

---

## Cadastrar eletrônico

```http
POST /eletronicos
```

### Body

```json
{
  "nome": "Geladeira",
  "modelo": "Frost Free",
  "consumo": 200,
  "quantidade": 5
}
```

A API retorna `HTTP 201 Created` após o cadastro.

---

## Atualizar eletrônico

```http
PUT /eletronicos/{id}
```

Exemplo:

```http
PUT /eletronicos/1
```

### Body

```json
{
  "nome": "Geladeira",
  "modelo": "Frost Free Inverter",
  "consumo": 180,
  "quantidade": 8
}
```

Antes de atualizar, o controller verifica se o ID informado existe.

---

## Excluir eletrônico

```http
DELETE /eletronicos/{id}
```

Exemplo:

```http
DELETE /eletronicos/1
```

A operação realiza a exclusão do registro através do `deleteById()` disponibilizado pelo Spring Data JPA.

---

# 🔁 Fluxo de uma requisição

Um exemplo de fluxo para o cadastro de um eletrônico:

```text
POST /eletronicos
       │
       ▼
EletronicoController
       │
       ▼
EletronicoRequestCreateDto
       │
       ▼
EletronicoMapper
       │
       ▼
Eletronicos
       │
       ▼
EletronicoService
       │
       ▼
EletronicoRepository
       │
       ▼
JPA / Hibernate
```

Na resposta, o caminho é invertido:

```text
Banco de dados
      │
      ▼
Eletronicos
      │
      ▼
EletronicoService
      │
      ▼
EletronicoMapper
      │
      ▼
EletronicoResponseDto
      │
      ▼
Resposta HTTP
```

Essa separação permite manter responsabilidades diferentes em componentes específicos da aplicação.

---

# ⚙️ Configuração

O arquivo de configuração está localizado em:

```text
src/main/resources/application.properties
```

Atualmente, ele contém apenas a identificação da aplicação:

```properties
spring.application.name=gsmicroservice
```

A configuração de banco de dados não está definida no `application.properties` atual. Portanto, a execução do projeto deve considerar essa característica da implementação original.

---

# 🚀 Como executar

## Pré-requisitos

* Java 23;
* Maven ou Maven Wrapper;
* IDE de sua preferência.

A versão do Java está definida no `pom.xml` como:

```xml
<java.version>23</java.version>
```

e o projeto utiliza Spring Boot `3.4.0`.

---

## 1. Clone o repositório

```bash
git clone https://github.com/gustavoconce/gs-microservice-fiap2sem.git
```

Entre na pasta:

```bash
cd gs-microservice-fiap2sem
```

---

## 2. Execute a aplicação

### Windows

```bash
./mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

Também é possível executar diretamente pela IDE através da classe:

```text
GsmicroserviceApplication.java
```

---

## 3. Acesse a API

Por padrão, a aplicação Spring Boot pode ser acessada em:

```text
http://localhost:8080
```

O endpoint principal é:

```text
http://localhost:8080/eletronicos
```

---

# 🧪 Testes

O projeto possui estrutura de testes utilizando Spring Boot Test.

O teste principal está localizado em:

```text
src/test/java/com/fiap/gsmicroservice/
```

com a classe:

```text
GsmicroserviceApplicationTests.java
```

Para executar os testes:

```bash
./mvnw test
```

No Windows:

```bash
./mvnw.cmd test
```

---

# 📌 Funcionalidades implementadas

* [x] Cadastro de eletrônicos
* [x] Listagem de eletrônicos
* [x] Consulta por ID
* [x] Consulta por nome
* [x] Atualização de eletrônicos
* [x] Exclusão de eletrônicos
* [x] Persistência utilizando JPA
* [x] DTOs de entrada e saída
* [x] Mapeamento com ModelMapper
* [x] Arquitetura em camadas
* [x] Teste de contexto da aplicação

---

# 🎓 Contexto acadêmico

Este projeto foi desenvolvido como uma **atividade acadêmica/prova da FIAP**, durante o segundo semestre, com foco na aplicação prática dos conceitos de desenvolvimento de microserviços.

Por esse motivo, o projeto deve ser interpretado como uma implementação acadêmica voltada ao aprendizado e avaliação dos conceitos apresentados na disciplina, e não como uma aplicação preparada para um ambiente de produção.

---

# 👨‍💻 Autor

**Gustavo Conceição**

Graduado em Sistemas de Informação pela FIAP, com interesse em desenvolvimento backend, APIs REST e construção de soluções utilizando Java e Spring Boot.

[GitHub](https://github.com/gustavoconce)

[LinkedIn](https://www.linkedin.com/in/gustavoconce/)
