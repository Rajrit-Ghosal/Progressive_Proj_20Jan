package com.wecp.progressive.entity;

public class CreditCard {

    private Long id;
    private String cardNumber;
    private String cardHolderName;
    public CreditCard() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCardHolderName() {
        return cardHolderName;
    }
    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
     
   public CreditCard(Long id, String cardNumber, String cardHolderName) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    public String toString() {
        return "CreditCard_id=" + id + ", cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName;
    }

    
}