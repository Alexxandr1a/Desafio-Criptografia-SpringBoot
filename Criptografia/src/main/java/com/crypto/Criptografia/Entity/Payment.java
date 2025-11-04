package com.crypto.Criptografia.Entity;

import com.crypto.Criptografia.CryptoConverter.CryptoConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CryptoConverter.class)
    private String creditCardToken;

    @Convert(converter = CryptoConverter.class)
    private String userDocument;

    private Long paymentValue;

    public Payment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserDocument() {
        return userDocument;
    }

    public void setUserDocument(String userDocument) {
        this.userDocument = userDocument;
    }

    public String getCreditCardToken() {
        return creditCardToken;
    }

    public void setCreditCardToken(String creditCardToken) {
        this.creditCardToken = creditCardToken;
    }

    public Long getpaymentValue() {
        return paymentValue;
    }

    public void setpaymentValue(Long paymentValue) {
        this.paymentValue = paymentValue;
    }
}
