package br.com.caelum.author.controller;

import br.com.caelum.author.controller.requests.AuthorRequest;
import br.com.caelum.author.model.Author;
import br.com.caelum.author.repository.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AuthorController {

    private final AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public ResponseEntity<Author> getBy(@PathVariable Long id) {
        return repository.
                findById(id)
                .map(ok()::body)
                .orElseGet(notFound()::build);
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody AuthorRequest authorRequest) {
        Author author = authorRequest.toDomain();

        repository.save(author);

        URI uri = UriComponentsBuilder.fromPath("{id}").build(author.getId());

        return created(uri).body(author);

    }

}
