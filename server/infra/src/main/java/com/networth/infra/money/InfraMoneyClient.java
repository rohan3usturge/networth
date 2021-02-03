package com.networth.infra.money;

public interface InfraMoneyClient {

    public InfraMoney convert(Double value, String currencyCode, String targetCurrencyCode);

}
