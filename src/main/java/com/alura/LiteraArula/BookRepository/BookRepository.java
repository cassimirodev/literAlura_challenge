package com.alura.LiteraArula.BookRepository;

import com.alura.LiteraArula.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
