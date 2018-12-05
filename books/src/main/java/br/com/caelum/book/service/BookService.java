package br.com.caelum.book.service;

import br.com.caelum.book.model.Book;
import br.com.caelum.book.rest.AuthorCLI;
import br.com.caelum.book.rest.response.AuthorResponse;
import br.com.caelum.book.controller.reponse.BookResponse;
import br.com.caelum.book.controller.request.BookRequest;
import br.com.caelum.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class BookService {
    private final BookRepository repository;
    private final AuthorCLI authorCLI;

    public BookService(BookRepository repository, AuthorCLI authorCLI) {
        this.repository = repository;
        this.authorCLI = authorCLI;
    }

    public Optional<BookResponse> loadById(Long id) {
        return repository.findById(id).map(this::mapToBookResponse);
    }

    private BookResponse mapToBookResponse(Book book) {
        AuthorResponse author = authorCLI.findById(book.getId());
        return new BookResponse(book.getId(), book.getTitle(), author.getName());
    }

    public List<BookResponse> all() {
        return repository.findAll().stream()
                            .map(this::mapToBookResponse)
                                    .collect(toList());
    }

    public BookResponse save(BookRequest bookRequest) {
        Book book = bookRequest.toDomain();

        repository.save(book);

        return mapToBookResponse(book);
    }
}
