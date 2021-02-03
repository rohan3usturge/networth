package com.networth.svc;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import com.networth.models.Currency;
import com.networth.repo.CurrencyRepository;
import com.networth.svc.models.AmountDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultCurrencyService implements CurrencyService {

    private CurrencyRepository repository;

    public DefaultCurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Double getConversionRate(String targetCurrency) {
        return 0.9;
    }

    @Override
    public List<Currency> getAll() {
        return repository.getAll();
    }

    @Override
    public AmountDm convert(Double value, String currencyCode, String targetCurrencyCode) {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.getDefault());
        Double sourceExchangeRate = null;
        Double targetExchangeRate = null;
        List<Currency> all = repository.getAll();
        for (Currency currency : all) {
            if (currency.getCurrencyCode().equals(currencyCode)) {
                sourceExchangeRate = currency.getExchangeRate();
            }
            if (currency.getCurrencyCode().equals(targetCurrencyCode)) {
                targetExchangeRate = currency.getExchangeRate();
            }
        }

        Double multiplier = targetExchangeRate / sourceExchangeRate;

        Double finalValue = value * multiplier;

        AmountDm infraMoney = new AmountDm();
        infraMoney.setValue(finalValue);
        infraMoney.setDisplayValue(currencyInstance.format(finalValue));
        return infraMoney;
    }

}
