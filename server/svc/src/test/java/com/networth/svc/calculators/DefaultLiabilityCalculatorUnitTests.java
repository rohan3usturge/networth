package com.networth.svc.calculators;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.networth.svc.CurrencyService;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LiabilityCategoryDm;
import com.networth.svc.models.LiabilityDm;
import com.networth.svc.models.LineItemDm;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

@RunWith(value = Parameterized.class)
public class DefaultLiabilityCalculatorUnitTests {
    private CalculationContext<List<LiabilityCategoryDm>> calculationContext;
    private Double expected;

    public DefaultLiabilityCalculatorUnitTests(CalculationContext<List<LiabilityCategoryDm>> calculationContext,
            Double expected, String testCaseName) {
        this.calculationContext = calculationContext;
        this.expected = expected;
    }

    private static CalculationContext<List<LiabilityCategoryDm>> nullCategoriesTestCase() {
        CalculationContext<List<LiabilityCategoryDm>> context = new CalculationContext<List<LiabilityCategoryDm>>(null,
                null, null);
        return context;
    }

    private static CalculationContext<List<LiabilityCategoryDm>> emptyCategoriesTestCase() {
        CalculationContext<List<LiabilityCategoryDm>> context = new CalculationContext<List<LiabilityCategoryDm>>(null,
                null, new ArrayList<LiabilityCategoryDm>());
        return context;
    }

    private static CalculationContext<List<LiabilityCategoryDm>> nullCategoryItemsTestCase() {
        List<LiabilityCategoryDm> categories = new ArrayList<LiabilityCategoryDm>();
        LiabilityCategoryDm category = new LiabilityCategoryDm();
        category.setItems(null);
        categories.add(category);
        CalculationContext<List<LiabilityCategoryDm>> context = new CalculationContext<List<LiabilityCategoryDm>>(null,
                null, categories);
        return context;
    }

    private static CalculationContext<List<LiabilityCategoryDm>> finiteValueTestCase() {
        List<LiabilityCategoryDm> categories = new ArrayList<LiabilityCategoryDm>();
        LiabilityCategoryDm category = new LiabilityCategoryDm();
        List<LiabilityDm> Liabilitys = new ArrayList<>();
        LiabilityDm Liability = new LiabilityDm();
        LineItemDm lineItem = new LineItemDm();
        lineItem.setAmount(10.0);
        Liability.setLineItem(lineItem);

        Liabilitys.add(Liability);
        category.setItems(Liabilitys);
        categories.add(category);

        CalculationContext<List<LiabilityCategoryDm>> context = new CalculationContext<List<LiabilityCategoryDm>>(null,
                null, categories);
        return context;
    }

    @Parameters(name = "{index}: calculate({2}, {1})")
    public static List<Object> data() {
        return Arrays.asList(
                new Object[][] { { null, 0.0, "Null Context" }, { nullCategoriesTestCase(), 0.0, "Null Categories" },
                        { emptyCategoriesTestCase(), 0.0, "Empty Categories" },
                        { nullCategoryItemsTestCase(), 0.0, "Null Category Items" },
                        { finiteValueTestCase(), 20.0, "10.0 Liabilitys" }, });
    }

    @Test
    public void shouldCalculateHandleInputsCorrectly() {

        // Arrange

        CurrencyService cServiceMock = Mockito.mock(CurrencyService.class);
        LiabilityCalculator calculator = new DefaultLiabilityCalculator(cServiceMock);

        if (this.calculationContext != null) {
            when(cServiceMock.convert(10.0, this.calculationContext.getCurrentCode(),
                    this.calculationContext.getTargetCurrencyCode())).thenReturn(20.0);
        }

        // Act

        Double actual = calculator.calculate(this.calculationContext);

        // Assert
        assertEquals(expected, actual);

    }

}
