package com.alura.LiteraArula.model;

import com.alura.LiteraArula.dto.Book;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Table(name = "book")
@Getter
@Setter
public class BookEntity {

    @Id
    @Column(columnDefinition = "TEXT")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private List<String> linguagens;

    @Column(columnDefinition = "TEXT")
    private List<String> sumario;

    @Column
    private Integer quantidadeDownloads;

    //

//    @JsonProperty("title")  String titulo,
//    @JsonProperty("languages")  List<String> linguagens,
//    @JsonProperty("download_count")  Integer quantidadeDownloads,
//    @JsonProperty("summaries")  List<String> sumario,
//    @JsonProperty ("name")  String nomeAutor,
//    @JsonProperty("birth_year")  Integer anoNascimento,
//    @JsonProperty("death_year")  Integer anoFalecimento

    public BookEntity (Book book) {
        this.titulo = book.titulo();
        this.linguagens = book.linguagens();
        this.sumario = book.sumario();
        this.quantidadeDownloads = book.quantidadeDownloads();
    }

}
