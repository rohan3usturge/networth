package com.networth.infra.money;

public class InfraMoney {

    private Double value;

    private String displayValue;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return "{" + " value='" + getValue() + "'" + ", displayValue='" + getDisplayValue() + "'" + "}";
    }

}
