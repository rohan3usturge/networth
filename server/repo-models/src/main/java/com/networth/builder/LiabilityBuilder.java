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

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Liability build() {
        return new Liability(new LineItem(this.id, this.name, this.amount), this.monthlyPayment);
    }

}
