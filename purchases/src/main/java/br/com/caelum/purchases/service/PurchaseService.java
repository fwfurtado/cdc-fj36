package br.com.caelum.purchases.service;

import br.com.caelum.purchases.controller.request.PurchaseOrder;
import br.com.caelum.purchases.model.Purchase;
import br.com.caelum.purchases.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {
    private final PurchaseRepository repository;

    public PurchaseService(PurchaseRepository repository) {
        this.repository = repository;
    }

    public Optional<Purchase> loadBy(Long id) {
        return repository.findById(id);
    }

    public Purchase createPurchaseBy(PurchaseOrder order) {

        Purchase purchase = order.toDomain();

        repository.save(purchase);

        return purchase;
    }
}
