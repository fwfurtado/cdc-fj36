package br.com.caelum.cdc.repository;

import br.com.caelum.cdc.model.Payment;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PaymentRepository extends Repository<Payment, Long> {
    Optional<Payment> findById(Long id);

    void save(Payment payment);
}
