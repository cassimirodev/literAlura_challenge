# LiteraAlura

LiteraAlura é uma aplicação de console desenvolvida em Java com Spring Boot. Ela permite que os usuários interajam com a API [Gutendex](https://gutendex.com/) para buscar livros, salvá-los em um banco de dados PostgreSQL e realizar consultas sobre os dados armazenados.

## Funcionalidades

*   **Buscar Livro por Título**: Busca um livro na API Gutendex pelo título e o salva no banco de dados local.
*   **Listar Livros Registrados**: Exibe todos os livros que foram salvos no banco de dados.
*   **Listar Autores Registrados**: Exibe todos os autores dos livros salvados.
*   **Listar Autores Vivos**: Permite pesquisar e listar autores que estavam vivos em um determinado ano.
*   **Listar Livros por Idioma**: Filtra e exibe os livros disponíveis em um idioma específico (ex: inglês, português, etc.).

## Tecnologias Utilizadas

*   **Java 17**
*   **Spring Boot**
*   **Spring Data JPA**
*   **PostgreSQL**
*   **Maven**
*   **Lombok**

## Como Executar

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/LiteraAlura.git
    ```

2.  **Configure o Banco de Dados:**
    *   Certifique-se de ter o PostgreSQL instalado e em execução.
    *   Crie um banco de dados (por exemplo, `postgres`).
    *   Atualize as credenciais do banco de dados no arquivo `src/main/resources/application.properties`:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
      spring.datasource.username=seu-usuario
      spring.datasource.password=sua-senha
      ```

3.  **Execute a aplicação:**
    *   Você pode executar a aplicação diretamente pela sua IDE (IntelliJ IDEA) ou usando o Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

Após a inicialização, o menu interativo será exibido no console.