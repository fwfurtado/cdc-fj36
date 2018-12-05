package br.com.caelum.cdc.service;

import br.com.caelum.cdc.controller.request.PaymentRequest;
import br.com.caelum.cdc.model.Payment;
import br.com.caelum.cdc.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    private PaymentRepository repository;

    public Optional<Payment> loadBy(Long id) {
        return repository.findById(id);
    }

    public Payment createPaymentBy(PaymentRequest request) {
        Payment payment = request.toDomain();

        repository.save(payment);

        return payment;
    }
}
