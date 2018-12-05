package br.com.caelum.cdc.purchases.model;


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

    /**
     * @deprecated frameworks eyes only
     */
    @Deprecated
    private Purchase() { }

    public Purchase(Long buyerId, List<Product> products) {
        this.products = products;
        this.buyerId = buyerId;
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

    public BigDecimal getTotal() {
        return products.stream()
                .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
