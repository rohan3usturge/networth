package com.networth.builder;

import com.networth.models.Currency;

public class CurrencyBuilder {

    private String currencyCode;

    private Double exchangeRate;

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public CurrencyBuilder currencyCode(String currencyCode) {
        setCurrencyCode(currencyCode);
        return this;
    }

    public CurrencyBuilder exchangeRate(Double exchangeRate) {
        setExchangeRate(exchangeRate);
        return this;
    }

    public Currency build() {
        return new Currency(this.currencyCode, this.exchangeRate);
    }

}
