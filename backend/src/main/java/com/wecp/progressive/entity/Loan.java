package com.wecp.progressive.entity;

public class Loan {

    private Long id;
    private String loanType;
    private double amount;
<<<<<<< HEAD
=======
    public Loan() {
    }
    public Loan(Long id, String loanType, double amount) {
        this.id = id;
        this.loanType = loanType;
        this.amount = amount;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Loan_id=" + id + ", loanType=" + loanType + ", amount=" + amount;
    }
    

    
>>>>>>> 8b7fdd6bb3e20280a92e6bcbce26f4bebc1c8b16

}