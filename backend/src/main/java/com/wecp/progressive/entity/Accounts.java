package com.wecp.progressive.entity;
import java.util.*;

//import ch.qos.logback.core.joran.conditional.ElseAction;

public class Accounts implements Comparable<Accounts>{
    private int account_id;
    private int customer_id;
    private double balance;
    // System.out.println("RECKERS");
    public Accounts() {
    }
    public Accounts(int account_id, int customer_id, double balance) {
        this.account_id = account_id;
        this.customer_id = customer_id;
        this.balance = balance;
    }
    public int getAccount_id() {
        return account_id;
    }
    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    public int compareTo(Accounts a)
    {
         if(this.balance>a.balance)
         {
            return -1;
         }
         else if(this.balance<a.balance)
         {
            return 1;
         }
         else{
            return 0;

         }
    }
    
    
    @Override
    public String toString() {
        return "account_id=" + account_id + ", customer_id=" + customer_id + ", balance=" + balance;
    }
    
    
    


}
