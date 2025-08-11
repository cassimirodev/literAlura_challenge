package com.alura.LiteraAlura.model;

import com.alura.LiteraAlura.dto.Autor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    public AutorEntity(Autor autor) {
        this.nomeAutor = autor.nomeAutor();
        this.anoNascimentoAutor = autor.anoNascimento();
        this.anoFalecimentoAutor = autor.anoFalecimento();
    }
}
