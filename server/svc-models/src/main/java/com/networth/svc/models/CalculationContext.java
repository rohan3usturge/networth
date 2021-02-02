package com.networth.svc.models;

public class CalculationContext<T> {

    private CurrencyCode currentCode;

    private T payload;

    public CalculationContext(CurrencyCode currentCode, T payload) {
        this.currentCode = currentCode;
        this.payload = payload;
    }

    public CurrencyCode getCurrentCode() {
        return this.currentCode;
    }

    public void setCurrentCode(CurrencyCode currentCode) {
        this.currentCode = currentCode;
    }

    public T getPayload() {
        return this.payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
