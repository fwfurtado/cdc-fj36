package br.com.caelum.purchases.controller;

import br.com.caelum.purchases.controller.request.PurchaseOrder;
import br.com.caelum.purchases.controller.response.PurchaseResponse;
import br.com.caelum.purchases.model.Purchase;
import br.com.caelum.purchases.service.PurchaseService;
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
public class PurchaseController {

    private final PurchaseService service;

    public PurchaseController(PurchaseService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<Purchase> loadById(@PathVariable Long id) {
        return service.loadBy(id).map(ok()::body).orElseGet(notFound()::build);
    }


    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody PurchaseOrder order) {
        Purchase purchase = service.createPurchaseBy(order);

        URI uri = UriComponentsBuilder.fromPath("{id}").build(purchase.getId());

        return created(uri).body(purchase);
    }

}
