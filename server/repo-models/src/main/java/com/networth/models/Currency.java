package com.networth.models;

public class Currency {

    private String currencyCode;

    private Double exchangeRate;

    public Currency(String currencyCode, Double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    public Currency currencyCode(String currencyCode) {
        setCurrencyCode(currencyCode);
        return this;
    }

    public Currency exchangeRate(Double exchangeRate) {
        setExchangeRate(exchangeRate);
        return this;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Double getExchangeRate() {
        return this.exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

}
