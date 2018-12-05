package br.com.caelum.purchases.rest.request;

import java.math.BigDecimal;

public class PaymentRequest {

    private final BigDecimal value;

    public PaymentRequest(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
