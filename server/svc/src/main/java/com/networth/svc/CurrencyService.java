package com.networth.svc;

import java.util.List;

import com.networth.models.Currency;

public interface CurrencyService {

    public List<Currency> getAll();

    public Double convert(Double value, String currencyCode, String targetCurrencyCode);

}
