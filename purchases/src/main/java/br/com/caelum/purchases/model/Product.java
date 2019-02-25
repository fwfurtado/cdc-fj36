package br.com.caelum.purchases.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Embeddable
public class Product {
    @NotNull
    private Long id;

    @NotNull
    private BigDecimal price;

    /**
     * @deprecated frameworks eyes only
     */
    @Deprecated
    private Product() {
    }

    public Product(Long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
