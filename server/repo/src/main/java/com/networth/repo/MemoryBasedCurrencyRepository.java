package com.networth.repo;

import java.util.ArrayList;
import java.util.List;

import com.networth.builder.CurrencyBuilder;
import com.networth.models.Currency;

import org.springframework.stereotype.Repository;

@Repository
public class MemoryBasedCurrencyRepository implements CurrencyRepository {

    @Override
    public List<Currency> getAll() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new CurrencyBuilder().currencyCode("CAD").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("USD").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("INR").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("GBP").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("EUR").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("AUD").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("NZD").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("CHF").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("CAD").exchangeRate(0.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("CAD").exchangeRate(0.0).build());
        return currencies;
    }

}
