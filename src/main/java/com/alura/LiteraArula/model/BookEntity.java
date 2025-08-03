package com.alura.LiteraArula.model;

import com.alura.LiteraArula.dto.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


//@JsonProperty("title") @NotNull
//String titulo,
//@JsonProperty("authors") @NotNull
//List<Person> autores,
//@JsonProperty("languages") @NotNull List<String> linguagens,
//@JsonProperty("download_count") @NotNull String quantidadeDownloads,
//@JsonProperty("summaries") @NotNull List<String> sumario

@Entity
@Table(name = "book")
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id_livro")
    @NotNull
    private Long idLivro;

    @Column(nullable = false, name = "titulo")
    @Size(min = 1, max = 80, message = "Titulo deve ter entre 1 e 80) caracteres")
    @NotNull
    private String titulo;

    @Column(nullable = false, name = "linguas")
    @Size(min = 1, max = 20, message = "Linguagens deve ter entre 1 e 20 caracteres")
    @NotNull
    private List<String> linguagens;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "book_sumarios", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "sumario")
    private List<String> sumario;

    @Column(nullable = false, name = "quantidade_downloads")
    @NotNull
    private Integer quantidadeDownloads;

    @ManyToMany(mappedBy = "livros", fetch = FetchType.EAGER)
    private List<PersonEntity> autores;

    public BookEntity() {}

    public BookEntity(Book book) {
        this.titulo = book.titulo();
        this.linguagens = book.linguagens();
        this.sumario = book.sumario();
        this.quantidadeDownloads = book.quantidadeDownloads();
    }
}
