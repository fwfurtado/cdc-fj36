package br.com.caelum.purchases.model;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Product> products = new ArrayList<>();

    @NotNull
    private Long buyerId;

    @NotNull
    private Long paymentId;

    /**
     * @deprecated frameworks eyes only
     */
    @Deprecated
    private Purchase() { }

    public Purchase(Long buyerId, List<Product> products, Long paymentId) {
        this.products = products;
        this.buyerId = buyerId;
        this.paymentId = paymentId;
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public BigDecimal getTotal() {
        return products.stream()
                .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
