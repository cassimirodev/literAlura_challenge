package com.alura.LiteraAlura;

import com.alura.LiteraAlura.dto.Book;
import com.alura.LiteraAlura.model.AutorEntity;
import com.alura.LiteraAlura.model.BookEntity;
import com.alura.LiteraAlura.repository.AutorRepository;
import com.alura.LiteraAlura.repository.BookRepository;
import com.alura.LiteraAlura.service.GutendexRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class LiteraAluraApplication implements CommandLineRunner {


	private final GutendexRequest gutendexRequest;
	private final BookRepository bookRepository;
	private final AutorRepository autorRepository;

	public LiteraAluraApplication(GutendexRequest gutendexRequest, BookRepository bookRepository, AutorRepository autorRepository) {
		this.gutendexRequest = gutendexRequest;
		this.bookRepository = bookRepository;
		this.autorRepository = autorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int option = -1;

		while (option != 0) {
			String menu = """
                    *** Escolha uma das opções abaixo ***
                    1 - Buscar livro pelo título e salvar no banco
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma
                    6 - Listar vários livros
                    0 - Sair
                    """;
			System.out.println(menu);

			try {
				option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
					case 1:
						System.out.println("Digite o título do livro para busca:");
						String bookTitle = scanner.nextLine();
						Optional<BookEntity> livroExistente = bookRepository.findByTituloIgnoreCase(bookTitle);

						if (livroExistente.isPresent()) {
							System.out.println("Livro já cadastrado no banco de dados.");
							System.out.println(livroExistente.get());
						} else {

							System.out.println("Buscando por: " + bookTitle);
							List<Book> booksFromApi = gutendexRequest.requestOnlyOneBook(bookTitle);
							if (!booksFromApi.isEmpty()) {
								BookEntity newBook = new BookEntity(booksFromApi.getFirst());
								bookRepository.save(newBook);
								System.out.println("Livro salvo com sucesso!");
								System.out.println(newBook);
							} else {
								System.out.println("Livro não encontrado na API.");
							}
						}
						break;
					case 2:
						List<BookEntity> livrosRegistrados = bookRepository.findAll();
						livrosRegistrados.forEach(System.out::println);
						break;
					case 3:
						List<AutorEntity> autoresRegistrados = autorRepository.findAll();
						autoresRegistrados.forEach(System.out::println);
						break;
					case 4:
						System.out.println("Digite o ano para pesquisar autores vivos:");
						int ano = scanner.nextInt();
						scanner.nextLine();
						List<AutorEntity> autoresVivos = autorRepository.findAutoresVivosNoAno(ano);
						autoresVivos.forEach(System.out::println);
						break;
					case 5:
						System.out.println("Digite o idioma para busca (ex: es, en, fr, pt):");
						String idioma = scanner.nextLine();
						List<BookEntity> livrosPorIdioma = bookRepository.findByIdioma(idioma);
						livrosPorIdioma.forEach(System.out::println);
						break;
					case 6:
						System.out.println("Buscando vários autores");
						List<Book> allBooksFromApi = gutendexRequest.requestAllBooks();
						for (Book book : allBooksFromApi) {
							BookEntity bookEntity = new BookEntity(book);
							bookRepository.save(bookEntity);
						}
						allBooksFromApi.forEach(System.out::println);
						break;
					case 0:
						System.out.println("Saindo do sistema...");
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Erro: Por favor, insira um número válido.");
				scanner.nextLine();
			}
		}
		scanner.close();
	}
}
