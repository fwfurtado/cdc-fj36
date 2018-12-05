package br.com.caelum.purchases.service;

import br.com.caelum.purchases.controller.request.PurchaseOrder;
import br.com.caelum.purchases.model.Purchase;
import br.com.caelum.purchases.repository.PurchaseRepository;
import br.com.caelum.purchases.rest.PaymentCLI;
import br.com.caelum.purchases.rest.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseService {
    private final PurchaseRepository repository;
    private final PaymentCLI paymentCLI;

    public PurchaseService(PurchaseRepository repository, PaymentCLI paymentCLI) {
        this.repository = repository;
        this.paymentCLI = paymentCLI;
    }

    public Optional<Purchase> loadBy(Long id) {
        return repository.findById(id);
    }

    public Purchase createPurchaseBy(PurchaseOrder order) {
        PaymentResponse payment = paymentCLI.createPaymentFor(order);

        Purchase purchase = order.toDomain(payment);

        repository.save(purchase);

        return purchase;
    }
}
