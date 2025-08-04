package com.alura.LiteraArula.service;


import com.alura.LiteraArula.repository.BookRepository;
import com.alura.LiteraArula.dto.Book;
import com.alura.LiteraArula.model.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final GutendexRequest gutendexRequest;
    private final BookRepository bookRepository;


    public BookService(GutendexRequest gutendexRequest, BookRepository bookRepository) {
        this.gutendexRequest = gutendexRequest;
        this.bookRepository = bookRepository;
    }

    public void salvarTodosLivrosRequisicao() {
        List<Book> books = gutendexRequest.requestAllBooks();

        for (Book book : books) {
            BookEntity bookEntity = new BookEntity(book);
            bookRepository.save(bookEntity);
        }
    }

//    public void salvarBuscaUnica {
//
//    }

    public long contarLivros() {
        return bookRepository.count();
    }


}
