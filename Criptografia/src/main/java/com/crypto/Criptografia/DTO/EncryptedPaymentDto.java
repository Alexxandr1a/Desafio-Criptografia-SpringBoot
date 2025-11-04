package com.crypto.Criptografia.dto;

public class EncryptedPaymentDto {
    private Long id;
    private String creditCardToken; 
    private String userDocument;    
    private Long paymentValue;

    public EncryptedPaymentDto(Long id, String creditCardToken, String userDocument, Long paymentValue) {
        this.id = id;
        this.creditCardToken = creditCardToken;
        this.userDocument = userDocument;
        this.paymentValue = paymentValue;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCreditCardToken() { return creditCardToken; }
    public void setCreditCardToken(String creditCardToken) { this.creditCardToken = creditCardToken; }

    public String getUserDocument() { return userDocument; }
    public void setUserDocument(String userDocument) { this.userDocument = userDocument; }

    public Long getPaymentValue() { return paymentValue; }
    public void setPaymentValue(Long paymentValue) { this.paymentValue = paymentValue; }
}
