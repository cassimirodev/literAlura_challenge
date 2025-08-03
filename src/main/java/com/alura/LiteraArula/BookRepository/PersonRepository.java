package com.alura.LiteraArula.BookRepository;

import com.alura.LiteraArula.model.PersonEntity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    Optional<PersonEntity> findByNome(String nome);
}
