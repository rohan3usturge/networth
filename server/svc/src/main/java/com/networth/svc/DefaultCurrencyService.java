package com.networth.svc;

import java.util.List;

import com.networth.infra.mapper.InfraMapper;
import com.networth.models.Currency;
import com.networth.repo.CurrencyRepository;

import org.springframework.stereotype.Service;

@Service
public class DefaultCurrencyService implements CurrencyService {

    private CurrencyRepository repository;
    private InfraMapper infraMapper;

    public DefaultCurrencyService(CurrencyRepository repository, InfraMapper infraMapper) {
        this.repository = repository;
        this.infraMapper = infraMapper;
    }

    @Override
    public Double getConversionRate(String targetCurrency) {
        return 0.9;
    }

    @Override
    public List<Currency> getAll() {
        return repository.getAll();
    }

}
