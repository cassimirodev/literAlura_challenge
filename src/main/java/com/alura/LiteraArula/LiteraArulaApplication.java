package com.alura.LiteraArula;

import com.alura.LiteraArula.dto.Book;
import com.alura.LiteraArula.service.GutendexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alura.LiteraArula.service.BookService;

import java.util.List;

@SpringBootApplication
public class LiteraArulaApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	@Autowired
	private GutendexRequest gutendexRequest;

	public static void main(String[] args) {
		SpringApplication.run(LiteraArulaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		List<Book> livros = gutendexRequest.requestAllBooks();

		livros.stream()
				.limit(3)
				.forEach(System.out::println);

	}
}
