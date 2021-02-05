package com.networth.svc.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.networth.svc.CurrencyService;
import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.AssetDm;
import com.networth.svc.models.CalculationContext;
import com.networth.svc.models.LineItemDm;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(value = Parameterized.class)
public class DefaultAssetCalculatorUnitTests {

    private CalculationContext<List<AssetCategoryDm>> calculationContext;
    private Double expected;

    public DefaultAssetCalculatorUnitTests(CalculationContext<List<AssetCategoryDm>> calculationContext,
            Double expected, String testCaseName) {
        this.calculationContext = calculationContext;
        this.expected = expected;
    }

    private static CalculationContext<List<AssetCategoryDm>> nullCategoriesTestCase() {
        CalculationContext<List<AssetCategoryDm>> context = new CalculationContext<List<AssetCategoryDm>>(null, null,
                null);
        return context;
    }

    private static CalculationContext<List<AssetCategoryDm>> emptyCategoriesTestCase() {
        CalculationContext<List<AssetCategoryDm>> context = new CalculationContext<List<AssetCategoryDm>>(null, null,
                new ArrayList<AssetCategoryDm>());
        return context;
    }

    private static CalculationContext<List<AssetCategoryDm>> nullCategoryItemsTestCase() {
        ArrayList<AssetCategoryDm> categories = new ArrayList<AssetCategoryDm>();
        AssetCategoryDm category = new AssetCategoryDm();
        category.setItems(null);
        categories.add(category);
        CalculationContext<List<AssetCategoryDm>> context = new CalculationContext<List<AssetCategoryDm>>(null, null,
                categories);
        return context;
    }

    private static CalculationContext<List<AssetCategoryDm>> finiteValueTestCase() {
        ArrayList<AssetCategoryDm> categories = new ArrayList<AssetCategoryDm>();
        AssetCategoryDm category = new AssetCategoryDm();
        List<AssetDm> assets = new ArrayList<>();
        AssetDm asset = new AssetDm();
        LineItemDm lineItem = new LineItemDm();
        lineItem.setAmount(10.0);
        asset.setLineItem(lineItem);

        assets.add(asset);
        category.setItems(assets);
        categories.add(category);

        CalculationContext<List<AssetCategoryDm>> context = new CalculationContext<List<AssetCategoryDm>>(null, null,
                categories);
        return context;
    }

    @Parameterized.Parameters(name = "{index}: calculate({2}, {1})")
    public static List<Object> data() {
        return Arrays.asList(
                new Object[][] { { null, 0.0, "Null Context" }, { nullCategoriesTestCase(), 0.0, "Null Categories" },
                        { emptyCategoriesTestCase(), 0.0, "Empty Categories" },
                        { nullCategoryItemsTestCase(), 0.0, "Null Category Items" },
                        { finiteValueTestCase(), 20.0, "10.0 Assets" }, });
    }

    @Test
    public void shouldCalculateHandleInputsCorrectly() {

        // Arrange

        CurrencyService cServiceMock = Mockito.mock(CurrencyService.class);
        AssetCalculator calculator = new DefaultAssetCalculator(cServiceMock);

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
