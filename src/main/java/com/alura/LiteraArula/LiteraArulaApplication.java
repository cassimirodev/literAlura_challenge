package com.alura.LiteraArula;

import com.alura.LiteraArula.dto.Book;
import com.alura.LiteraArula.service.GutendexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class LiteraArulaApplication implements CommandLineRunner {

	@Autowired
	private GutendexRequest gutendexRequest;

	public static void main(String[] args) {
		SpringApplication.run(LiteraArulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Chama o método requestAllBooks do serviço GutendexRequest
		List<Book> books = gutendexRequest.requestAllBooks();

		// Imprime os livros retornados
		for (Book book : books) {
			System.out.println("Título: " + book.titulo());
			System.out.println("Autores: " + book.autores());
			System.out.println("Linguagens: " + book.linguagens());
			System.out.println("Quantidade de Downloads: " + book.quantidadeDownloads());
			System.out.println("Sumário: " + book.sumario());
			System.out.println("-----------------------------");
		}
	}



}
