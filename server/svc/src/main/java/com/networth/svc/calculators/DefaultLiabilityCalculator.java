package com.networth.svc.calculators;

import java.util.List;

import com.networth.svc.CurrencyService;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LiabilityCategoryDm;
import com.networth.svc.models.LiabilityDm;
import com.networth.svc.models.LineItemDm;

import org.springframework.stereotype.Service;

@Service
public class DefaultLiabilityCalculator implements LiabilityCalculator {

    private CurrencyService currencyService;

    public DefaultLiabilityCalculator(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public Double calculate(CalculationContext<List<LiabilityCategoryDm>> context) {
        Double total = 0.0;
        if (context == null || context.getPayload() == null || context.getPayload().isEmpty()) {
            return total;
        }
        for (LiabilityCategoryDm category : context.getPayload()) {
            if (category.getItems() == null) {
                continue;
            }
            for (LiabilityDm item : category.getItems()) {
                LineItemDm lineItem = item.getLineItem();
                Double amount = currencyService.convert(lineItem.getAmount(), context.getCurrentCode(),
                        context.getTargetCurrencyCode());
                lineItem.setAmount(amount);
                total += lineItem.getAmount();
            }
        }
        return total;
    }

}
