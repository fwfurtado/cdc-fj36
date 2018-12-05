package br.com.caelum.cdc.purchases.repository;

import br.com.caelum.cdc.purchases.model.Purchase;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface PurchaseRepository extends Repository<Purchase, Long> {
    Optional<Purchase> findById(Long id);

    void save(Purchase purchase);
}
