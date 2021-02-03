package com.networth.infra.money;

import java.util.Currency;
import java.util.Locale;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;

public class JavaMoneyBasedMoneyClient implements InfraMoneyClient {

    @Override
    public InfraMoney convert(Double value, String currencyCode, String targetCurrencyCode) {
        Money money = Money.of(value, currencyCode);
        CurrencyConversion targetConversion = MonetaryConversions.getConversion(targetCurrencyCode);
        MonetaryAmount convertedAmount = money.with(targetConversion);
        MonetaryAmountFormat localFormat = MonetaryFormats.getAmountFormat(Locale.getDefault());
        Currency currency = Currency.getInstance(targetCurrencyCode);
        currency.getDefaultFractionDigits();
        InfraMoney infraMoney = new InfraMoney();
        infraMoney.setDisplayValue(localFormat.format(convertedAmount));
        infraMoney.setValue(convertedAmount.getNumber().doubleValue());
        return infraMoney;
    }

}
