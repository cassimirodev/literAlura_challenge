package com.alura.LiteraArula.service;

import com.alura.LiteraArula.dto.Book;
import com.alura.LiteraArula.dto.GutendexResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


@Service
public class GutendexRequest {

    // retorna uma lista de livros do endpoint /books
    public List<Book> requestAllBooks() {
        // faz uma requisição HTTP para a API do Gutendex e retorna uma lista de livros
        // A API retorna um JSON mapeado para a classe GutendexResponse
        try {
            // utiliza http client do java net para fazer a requisição
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://gutendex.com/books/"))
                    .GET()
                    .build();
            // aqui o client envia a req e recebe a resposta, transformando o corpo da resposta em string
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // verifica se o status da resposta é 200 (OK), se não for, lança uma exceção e imprime o codigo http
            if (response.statusCode() != 200) {
                throw new RuntimeException("Falha na requisição HTTP: " + response.statusCode());
            }

            // transforma o body response em uma string
            String jsonBodyAllBooksResponse = response.body();
            // utiliza a biblioteca Jackson para mapear o JSON para a classe GutendexResponse
            ObjectMapper mapper = new ObjectMapper();
            // lê o JSON e converte para um objeto GutendexResponse (Semelhante ao Gson)
            GutendexResponse gutendexResponse = mapper.readValue(jsonBodyAllBooksResponse, GutendexResponse.class);

            // retorna uma lista de livros contidos no objeto GutendexResponse
            return gutendexResponse.results();
        } catch (IOException | InterruptedException e) { // trata exceções de IO e interrupção
            e.printStackTrace();
            throw new RuntimeException("Erro ao chamar API", e);
        }

    }
}
