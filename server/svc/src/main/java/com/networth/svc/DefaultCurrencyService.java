package com.networth.svc;

import java.util.EnumMap;
import java.util.Map;

import com.networth.svc.models.CurrencyCode;

import org.springframework.stereotype.Service;

@Service
public class DefaultCurrencyService implements CurrencyService {

    private Map<CurrencyCode, Double> exchangeRates;

    public DefaultCurrencyService() {
        this.exchangeRates = new EnumMap<>(CurrencyCode.class);
        this.exchangeRates.put(CurrencyCode.CAD, 1.0);
        this.exchangeRates.put(CurrencyCode.USD, 0.8);
        this.exchangeRates.put(CurrencyCode.INR, 50.0);
        this.exchangeRates.put(CurrencyCode.AUD, 1.1);
        this.exchangeRates.put(CurrencyCode.NZD, 1.05);
        this.exchangeRates.put(CurrencyCode.EUR, 0.7);
        this.exchangeRates.put(CurrencyCode.GBP, 0.5);
    }

    @Override
    public Double getConversionRate(CurrencyCode targetCurrency) {
        return this.exchangeRates.getOrDefault(targetCurrency, 1.0);
    }

    @Override
    public String getCurrencySymbol(CurrencyCode targetCurrency) {
        return "$";
    }

}
