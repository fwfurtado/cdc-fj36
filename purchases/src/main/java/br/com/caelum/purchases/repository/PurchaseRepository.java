package br.com.caelum.purchases.repository;

import br.com.caelum.purchases.model.Purchase;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PurchaseRepository extends Repository<Purchase, Long> {
    Optional<Purchase> findById(Long id);

    void save(Purchase purchase);
}
