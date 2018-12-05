package br.com.caelum.payment.controller.request;

import br.com.caelum.payment.model.Payment;

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
