package br.com.caelum.cdc.repository;

import br.com.caelum.cdc.model.Book;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends Repository<Book, Long> {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    void save(Book book);
}
