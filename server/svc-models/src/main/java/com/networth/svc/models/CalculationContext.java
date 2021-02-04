package com.networth.svc.models;

public class CalculationContext<T> {

    private String currentCode;
    private String targetCurrencyCode;

    private T payload;

    public CalculationContext(String currentCode, String targetCurrencyCode, T payload) {
        this.currentCode = currentCode;
        this.targetCurrencyCode = targetCurrencyCode;
        this.payload = payload;
    }

    public String getTargetCurrencyCode() {
        return this.targetCurrencyCode;
    }

    public void setTargetCurrencyCode(String targetCurrencyCode) {
        this.targetCurrencyCode = targetCurrencyCode;
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
