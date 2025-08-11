package com.alura.LiteraAlura.model;

import com.alura.LiteraAlura.dto.Autor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AutorEntity {
    @Id
    @Column(columnDefinition = "TEXT")
    private String nomeAutor;

    @Column
    private Integer anoNascimentoAutor;

    @Column
    private Integer anoFalecimentoAutor;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "autores", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ToString.Exclude
    private List<BookEntity> livros;

    public AutorEntity(Autor autor) {
        this.nomeAutor = autor.nomeAutor();
        this.anoNascimentoAutor = autor.anoNascimento();
        this.anoFalecimentoAutor = autor.anoFalecimento();
    }
}
