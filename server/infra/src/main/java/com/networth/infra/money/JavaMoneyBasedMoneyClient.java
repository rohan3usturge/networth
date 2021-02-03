package com.networth.infra.money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public class JavaMoneyBasedMoneyClient {

    public void test() {
        CurrencyUnit unit = Monetary.getCurrency("currencyCode");
    }

}
