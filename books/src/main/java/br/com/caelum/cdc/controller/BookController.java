package br.com.caelum.cdc.controller;

import br.com.caelum.cdc.controller.reponse.BookResponse;
import br.com.caelum.cdc.controller.request.BookRequest;
import br.com.caelum.cdc.model.Book;
import br.com.caelum.cdc.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<BookResponse> getBy(@PathVariable Long id) {
        return service.loadById(id)
                .map(ok()::body)
                .orElseGet(notFound()::build);
    }


    @GetMapping
    public ResponseEntity<List<BookResponse>> loadAll() {

        List<BookResponse> books = service.all();

        if (books.isEmpty()) {
            return notFound().build();
        }

        return ok(books);
    }


    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest) {
        BookResponse book = service.save(bookRequest);

        URI uri = UriComponentsBuilder.fromPath("{id}").build(book.getId());

        return created(uri).body(book);
    }
}
