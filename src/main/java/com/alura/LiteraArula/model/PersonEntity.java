package com.alura.LiteraArula.model;


import com.alura.LiteraArula.dto.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//  @JsonProperty ("name") @NotNull String nome,
//        @JsonProperty("birth_year") @NotNull Integer anoNascimento,
//        @JsonProperty("death_year") @NotNull Integer anoFalecimento

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity {

    @Id
    @Column(name = "id_pessoa", nullable = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;


    @Column(name = "nome_pessoa", nullable = false)
    @NotNull
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    private String nome;

    @Column(name = "ano_nascimento", nullable = false)
    @NotNull
    private Integer anoNascimento;

    @Column(name = "nome", nullable = false)
    @NotNull
    private Integer anofalecimento;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "autor_livro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    @NotNull
    private List<BookEntity> livros;

    public PersonEntity() {}

    public PersonEntity(Person person) {
        this.nome = person.nome();
        this.anoNascimento = person.anoNascimento();
        this.anofalecimento = person.anoFalecimento();
    }

}
