package br.com.caelum.buyer.controller.request;

import br.com.caelum.buyer.model.Buyer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class BuyerRequest {
    @Email
    @NotBlank
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Buyer toDomain() {
        return new Buyer(email);
    }
}
