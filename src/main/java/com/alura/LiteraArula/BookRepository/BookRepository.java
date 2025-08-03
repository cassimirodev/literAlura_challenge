package com.alura.LiteraArula.BookRepository;

import com.alura.LiteraArula.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    Optional<BookEntity> findByTitulo(String titulo);
}
