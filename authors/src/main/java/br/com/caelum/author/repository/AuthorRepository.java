package br.com.caelum.author.repository;

import br.com.caelum.author.model.Author;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AuthorRepository extends Repository<Author, Long> {
    Optional<Author> findById(Long id);

    void save(Author author);
}
