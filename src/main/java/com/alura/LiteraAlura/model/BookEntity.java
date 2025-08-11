package com.alura.LiteraAlura.model;

import com.alura.LiteraAlura.dto.Book;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookEntity {

    @Id
    @Column(columnDefinition = "TEXT")
    private String titulo;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_linguagens", joinColumns = @JoinColumn(name = "book_titulo"))
    @Column(name = "linguagem", columnDefinition = "TEXT")
    private List<String> linguagens;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_sumario", joinColumns = @JoinColumn(name = "book_titulo"))
    @Column(name = "sumario", columnDefinition = "TEXT")
    private List<String> sumario;

    @Column
    private Integer quantidadeDownloads;


    public BookEntity (Book book) {
        this.titulo = book.titulo();
        this.linguagens = book.linguagens();
        this.sumario = book.sumario();
        this.quantidadeDownloads = book.quantidadeDownloads();
    }

}
