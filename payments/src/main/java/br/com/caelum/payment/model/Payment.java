package br.com.caelum.payment.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;


    /**
     * @deprecated framework eyes only
     */
    @Deprecated
    private Payment() {
    }

    public Payment(@NotNull BigDecimal value) {
        this.value = value;
        this.status = PaymentStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
