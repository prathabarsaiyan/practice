package main.pratha.splitExpenses.model;

import java.util.List;

public abstract class Expense {
    private String id;
    private double amount;
    private User payer;
    private List<Split> splits;

    public Expense(double amount, User payer, List<Split> splits) {
        this.amount = amount;
        this.payer = payer;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public abstract boolean validate();
}


