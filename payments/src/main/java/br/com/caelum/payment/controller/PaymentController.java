package br.com.caelum.payment.controller;

import br.com.caelum.payment.controller.request.PaymentRequest;
import br.com.caelum.payment.model.Payment;
import br.com.caelum.payment.service.PaymentService;
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
public class PaymentController {


    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<Payment> loadById(@PathVariable Long id) {
        return service.loadBy(id).map(ok()::body).orElseGet(notFound()::build);
    }

    @PostMapping
    public ResponseEntity<Payment> save(@RequestBody PaymentRequest paymentRequest) {

        Payment payment = service.createPaymentBy(paymentRequest);

        URI uri = UriComponentsBuilder.fromPath("{id}").build(payment.getId());

        return created(uri).body(payment);
    }
}
