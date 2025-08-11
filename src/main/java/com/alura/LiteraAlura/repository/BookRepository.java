package com.alura.LiteraAlura.repository;

import com.alura.LiteraAlura.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {

    Optional<BookEntity> findByTituloIgnoreCase(String titulo);

    @Query("SELECT b FROM BookEntity b WHERE :idioma MEMBER OF b.linguagens")
    List<BookEntity> findByIdioma(String idioma);
}