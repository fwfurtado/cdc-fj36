package br.com.caelum.cdc.controller.request;

import br.com.caelum.cdc.model.Payment;

import java.math.BigDecimal;

public class PaymentRequest {
    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Payment toDomain() {
        return new Payment(value);
    }
}
