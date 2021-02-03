package com.networth.svc;

import java.util.List;

import com.networth.models.Currency;
import com.networth.svc.models.AmountDm;

public interface CurrencyService {

    public Double getConversionRate(String targetCurrency);

    public List<Currency> getAll();

    public AmountDm convert(Double value, String currencyCode, String targetCurrencyCode);

}
