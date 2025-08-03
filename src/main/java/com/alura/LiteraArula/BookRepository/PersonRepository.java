package com.alura.LiteraArula.BookRepository;

import com.alura.LiteraArula.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
