package com.networth.builder;

import java.util.UUID;

import com.networth.models.Liability;
import com.networth.models.LineItem;

public class LiabilityBuilder {
    private String id;
    private String name;
    private Double amount;
    private Double monthlyPayment;

    public LiabilityBuilder() {
        this.id = UUID.randomUUID().toString();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAmount(Double amount) {
        this.amount = amount;
    }

    private void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public LiabilityBuilder name(String name) {
        setName(name);
        return this;
    }

    public LiabilityBuilder amount(Double amount) {
        setAmount(amount);
        return this;
    }

    public LiabilityBuilder monthlyPayment(Double monthlyPayment) {
        setMonthlyPayment(monthlyPayment);
        return this;
    }

    public Liability build() {
        return new Liability(new LineItem(this.id, this.name, this.amount), this.monthlyPayment);
    }

}
