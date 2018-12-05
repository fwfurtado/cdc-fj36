package br.com.caelum.payment.service;

import br.com.caelum.payment.controller.request.PaymentRequest;
import br.com.caelum.payment.model.Payment;
import br.com.caelum.payment.repository.PaymentRepository;
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
