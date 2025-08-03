package com.alura.LiteraArula.model;

import com.alura.LiteraArula.dto.Autor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
