package br.com.caelum.authors.repository;

import br.com.caelum.authors.model.Author;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface AuthorRepository extends Repository<Author, Long> {
    Optional<Author> findById(Long id);

    void save(Author author);
}
