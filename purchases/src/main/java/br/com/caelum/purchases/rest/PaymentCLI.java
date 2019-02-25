package br.com.caelum.purchases.rest;

import br.com.caelum.purchases.controller.request.PurchaseOrder;
import br.com.caelum.purchases.model.Purchase;
import br.com.caelum.purchases.rest.request.PaymentRequest;
import br.com.caelum.purchases.rest.response.PaymentResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentCLI {
    private static final String ENDPOINT = "http://localhost:8050/";
    private final RestTemplate rest;

    public PaymentCLI(RestTemplate rest) {
        this.rest = rest;
    }

    public PaymentResponse createPaymentFor(PurchaseOrder order) {
        return rest.postForObject(ENDPOINT, new PaymentRequest(order.getTotal()), PaymentResponse.class);
    }
}
