package com.networth.svc;

import com.networth.svc.models.CurrencyCode;

public interface CurrencyService {

    public Double getConversionRate(CurrencyCode targetCurrency);

    public String getCurrencySymbol(CurrencyCode targetCurrency);

}
