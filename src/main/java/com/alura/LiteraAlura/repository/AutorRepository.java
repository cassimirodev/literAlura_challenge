package com.alura.LiteraAlura.repository;

import com.alura.LiteraAlura.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, String> {

    Optional<AutorEntity> findByNomeAutorIgnoreCase(String nomeAutor);

    @Query("SELECT autor FROM AutorEntity autor WHERE autor.anoNascimentoAutor <= :ano AND (autor.anoFalecimentoAutor IS NULL OR autor.anoFalecimentoAutor >= :ano)")
    List<AutorEntity> findAutoresVivosNoAno(int ano);
}