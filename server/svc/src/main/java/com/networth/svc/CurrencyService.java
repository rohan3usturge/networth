package com.networth.svc;

import java.util.List;

import com.networth.models.Currency;

public interface CurrencyService {

    public Double getConversionRate(String targetCurrency);

    public List<Currency> getAll();

}
