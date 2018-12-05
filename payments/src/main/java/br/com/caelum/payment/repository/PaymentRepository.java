package br.com.caelum.payment.repository;

import br.com.caelum.payment.model.Payment;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PaymentRepository extends Repository<Payment, Long> {
    Optional<Payment> findById(Long id);

    void save(Payment payment);
}
