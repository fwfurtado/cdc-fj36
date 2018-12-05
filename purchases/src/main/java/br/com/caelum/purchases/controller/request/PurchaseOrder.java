package br.com.caelum.purchases.controller.request;

import br.com.caelum.purchases.model.Product;
import br.com.caelum.purchases.model.Purchase;
import br.com.caelum.purchases.rest.response.PaymentResponse;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrder {
    private Long buyerId;
    private List<Product> products;

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Purchase toDomain(PaymentResponse payment) {
       return new Purchase(buyerId, products, payment.getId());
    }

    public BigDecimal getTotal() {
        return products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
