package com.networth.svc.models;

public class CalculationContext<T> {

    private String currentCode;

    private T payload;

    public CalculationContext(String currentCode, T payload) {
        this.currentCode = currentCode;
        this.payload = payload;
    }

    public String getCurrentCode() {
        return this.currentCode;
    }

    public void setCurrentCode(String currentCode) {
        this.currentCode = currentCode;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
