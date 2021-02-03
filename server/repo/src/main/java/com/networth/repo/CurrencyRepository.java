package com.networth.repo;

import java.util.List;

import com.networth.models.Currency;

public interface CurrencyRepository {

    List<Currency> getAll();

}
