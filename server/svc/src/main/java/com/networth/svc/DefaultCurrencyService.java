package com.networth.svc;

import java.util.List;

import com.networth.infra.exception.ApiException;
import com.networth.infra.exception.ApiExceptionType;
import com.networth.models.Currency;
import com.networth.repo.CurrencyRepository;

import org.springframework.stereotype.Service;

@Service
public class DefaultCurrencyService implements CurrencyService {

    private CurrencyRepository repository;

    public DefaultCurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Currency> getAll() {
        return repository.getAll();
    }

    @Override
    public Double convert(Double value, String currencyCode, String targetCurrencyCode) {
        if (value == null || currencyCode == null || targetCurrencyCode == null) {
            return value;
        }
        if (currencyCode.equalsIgnoreCase(targetCurrencyCode)) {
            return value;
        }
        Double sourceExchangeRate = null;
        Double targetExchangeRate = null;
        List<Currency> all = repository.getAll();
        if (all != null) {
            for (Currency currency : all) {
                if (currency.getCurrencyCode().equals(currencyCode)) {
                    sourceExchangeRate = currency.getExchangeRate();
                }
                if (currency.getCurrencyCode().equals(targetCurrencyCode)) {
                    targetExchangeRate = currency.getExchangeRate();
                }
            }
        }
        if (sourceExchangeRate == null || targetExchangeRate == null) {
            throw new ApiException(ApiExceptionType.DB, "CurrencyServiceIssue",
                    "Currency exchange rate Could not be fetched");
        }
        Double multiplier = targetExchangeRate / sourceExchangeRate;
        return value * multiplier;
    }

}
