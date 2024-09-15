# SuperaList Application

SuperaList é uma API RESTful desenvolvida em Java com o framework Spring Boot. A aplicação gerencia listas e tarefas, permitindo a criação, edição, exclusão e recuperação de itens. A API também oferece documentação interativa via Swagger.

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **H2 Database** (Banco de dados em memória)
- **Swagger** (para documentação da API)
- **Jakarta Validation**

## ⚙️ Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:

- **Java 17** ou superior
- **Maven** para gerenciar dependências e compilar o projeto
- **Git** para controle de versão

## 🗄️ Configuração do Banco de Dados H2

A aplicação utiliza o **H2 Database** como banco de dados em memória. Para acessá-lo, siga os passos abaixo:

1. Durante a execução da aplicação, você pode acessar o console do H2 através do seguinte link:

    ```
    http://localhost:8080/h2-console
    ```

2. Utilize as seguintes credenciais para o login no H2 console:

    - **JDBC URL**: `jdbc:h2:mem:testdb`
    - **Username**: `sa`
    - **Password**: `pass`

3. O banco de dados será criado e gerenciado automaticamente pelo Spring Boot durante o tempo de execução.

## 🚀 Instalação e Execução

Siga os passos abaixo para configurar e rodar a aplicação:

1. **Clone o repositório**:

    ```bash
    git clone https://github.com/renancba/SuperaTaskApi.git
    cd SuperaTaskApi
    ```

2. **Compile e rode a aplicação** utilizando o Maven:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. A aplicação estará disponível no seguinte endereço:

    ```
    http://localhost:8080
    ```

## 📋 Endpoints da API

A API possui endpoints para gerenciar **listas** e **tarefas**:

- **Listas**
    - `GET /api/listas` - Retorna todas as listas
    - `GET /api/listas/{id}` - Retorna uma lista específica pelo ID
    - `POST /api/listas` - Cria uma nova lista
    - `PUT /api/listas/{id}` - Atualiza uma lista pelo ID
    - `DELETE /api/listas/{id}` - Deleta uma lista pelo ID

- **Tarefas**
    - `GET /api/tarefas` - Retorna todas as tarefas
    - `GET /api/tarefas/{id}` - Retorna uma tarefa específica pelo ID
    - `POST /api/tarefas` - Cria uma nova tarefa
    - `PUT /api/tarefas/{id}` - Atualiza uma tarefa pelo ID
    - `DELETE /api/tarefas/{id}` - Deleta uma tarefa pelo ID

## 📖 Documentação da API com Swagger

A documentação da API está disponível através do Swagger, que permite visualizar e testar os endpoints diretamente no navegador.

Para acessar a documentação do Swagger, abra o seguinte link no navegador:

http://localhost:8080/swagger-ui/index.html


Aqui está uma prévia de como a documentação do Swagger será exibida:

https://ibb.co/JsMSb6K

## ✅ Testes

Para executar os testes unitários, utilize o seguinte comando:

```bash
mvn test
```

Os testes cobrem as funcionalidades principais dos controllers de listas e tarefas.

## 📄 Licença

Este projeto está licenciado sob os termos da licença MIT.