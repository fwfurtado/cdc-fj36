package br.com.caelum.buyer.controller;

import br.com.caelum.buyer.controller.request.BuyerRequest;
import br.com.caelum.buyer.model.Buyer;
import br.com.caelum.buyer.repository.BuyerRepository;
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
public class BuyerController {

    private final BuyerRepository repository;

    public BuyerController(BuyerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Buyer> loadBy(@PathVariable String email) {
        return repository.findByEmail(email).map(ok()::body).orElseGet(notFound()::build);
    }


    @GetMapping("{id}")
    public ResponseEntity<Buyer> loadById(@PathVariable Long id) {
        return repository.findById(id).map(ok()::body).orElseGet(notFound()::build);
    }

    @PostMapping
    public ResponseEntity<Buyer> save(@RequestBody BuyerRequest buyerRequest) {
        Buyer buyer = buyerRequest.toDomain();

        repository.save(buyer);

        URI uri = UriComponentsBuilder.fromPath("{id}").build(buyer.getId());

        return created(uri).body(buyer);
    }
}
