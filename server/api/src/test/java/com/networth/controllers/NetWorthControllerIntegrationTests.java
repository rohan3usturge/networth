package com.networth.controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.networth.dto.NetWorthRequestDto;
import com.networth.dto.NetWorthResponseDto;
import com.networth.infra.utils.JsonUtils;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.NetWorthDm;
import com.networth.svc.models.PortfolioDm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest(classes = { com.networth.api.ApiApplication.class })
@AutoConfigureMockMvc
public class NetWorthControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnCurrenciesCorrectly() throws Exception {
        MvcResult returned = this.mockMvc.perform(get("/networth/currencies")).andExpect(status().isOk()).andReturn();
        String json = returned.getResponse().getContentAsString();
        List<String> currencies = toList(String.class, JsonUtils.fromJson(json, List.class));
        assertNotNull(currencies);
        assertEquals(10, currencies.size());
    }

    @Test
    public void shouldCalculateNetWorthCorrectly() throws Exception {
        // Arrange
        String lineItemJson = "{\"assets\":[{\"meta\":{\"id\":\"ba70e271-ddb1-4c84-9444-703f6e10b2cb\",\"name\":\"Cash and Investments\"},\"items\":[{\"lineItem\":{\"id\":\"68caee48-30d8-4dde-a57b-133098825428\",\"name\":\"Chequing\",\"amount\":2000}},{\"lineItem\":{\"id\":\"8036c644-37ab-41e9-8d8e-bf59c200e793\",\"name\":\"Savings for Taxes\",\"amount\":4000}},{\"lineItem\":{\"id\":\"ec228caf-fe36-4de5-8bb6-8f5aa40e2e28\",\"name\":\"Rainy Day Fund\",\"amount\":506}},{\"lineItem\":{\"id\":\"4dbe0cdc-a542-4257-8fb3-d657b7fdf526\",\"name\":\"Savings for Fun\",\"amount\":5000}},{\"lineItem\":{\"id\":\"4526ba8f-8b9f-4fda-a244-66853ff325dd\",\"name\":\"Savings for Travel\",\"amount\":400}},{\"lineItem\":{\"id\":\"10ef977d-06be-4012-87d7-54f1a683efe2\",\"name\":\"Savings for Personal Development\",\"amount\":200}},{\"lineItem\":{\"id\":\"9ecfbcf9-a0b5-4224-9d15-1590a1a8bb9f\",\"name\":\"Investment 1\",\"amount\":5000}},{\"lineItem\":{\"id\":\"6b96a9c8-c568-4aed-b29c-6f437aa8beba\",\"name\":\"Investment 2\",\"amount\":60000}},{\"lineItem\":{\"id\":\"62a8aa62-47ab-4d46-b541-006491fad3f2\",\"name\":\"Investment 3\",\"amount\":30000}},{\"lineItem\":{\"id\":\"daeefb0b-afde-43cf-8438-7dd29f95d1b4\",\"name\":\"Investment 4\",\"amount\":50000}},{\"lineItem\":{\"id\":\"11f298df-641f-4610-93e5-aba5c5fe8356\",\"name\":\"Investment 5\",\"amount\":24000}}]},{\"meta\":{\"id\":\"758443d6-0ae2-490e-9742-a92400b63829\",\"name\":\"Long Term Assets\"},\"items\":[{\"lineItem\":{\"id\":\"db3c9bac-29c7-4d96-8733-b87396f856fa\",\"name\":\"Primary Home\",\"amount\":455000}},{\"lineItem\":{\"id\":\"ea88a970-ac43-4eb6-a815-33b3f8969c93\",\"name\":\"Second Home\",\"amount\":1564321}},{\"lineItem\":{\"id\":\"0a61ff81-c8c2-4246-9eac-58f732857d3e\",\"name\":\"Other\",\"amount\":0}}]}],\"liabilities\":[{\"meta\":{\"id\":\"eed51271-58d7-4775-836c-a81162435eca\",\"name\":\"Short Term Liabilties\"},\"items\":[{\"lineItem\":{\"id\":\"33a55f37-9a8a-4916-9ec4-4eca1ea65e63\",\"name\":\"Credit Card 1\",\"amount\":4342},\"monthlyPayment\":200},{\"lineItem\":{\"id\":\"69073a86-7253-40ad-9467-adac336ded04\",\"name\":\"Credit Card 2\",\"amount\":322},\"monthlyPayment\":150}]},{\"meta\":{\"id\":\"ceae184d-7b80-4d4c-be54-0164f28b87dd\",\"name\":\"Long Term Debt\"},\"items\":[{\"lineItem\":{\"id\":\"7cf73064-edb5-4f61-b3cc-2ccb5f828b07\",\"name\":\"Mortgage 1\",\"amount\":250999},\"monthlyPayment\":2000},{\"lineItem\":{\"id\":\"6c2cbf74-24d1-4e33-b0e2-2e1f4a64b0c6\",\"name\":\"Mortgage 2\",\"amount\":632634},\"monthlyPayment\":3500},{\"lineItem\":{\"id\":\"8e4b2878-158e-4dc8-adce-0624626a111f\",\"name\":\"Line of Credit\",\"amount\":10000},\"monthlyPayment\":500},{\"lineItem\":{\"id\":\"6309f78a-849a-45ed-a78b-6fa3778b234d\",\"name\":\"Investment Loan\",\"amount\":10000},\"monthlyPayment\":700},{\"lineItem\":{\"id\":\"eaa84529-3c22-4377-8acc-47e5548ce06d\",\"name\":\"Student Loan\",\"amount\":0},\"monthlyPayment\":null},{\"lineItem\":{\"id\":\"589db9d2-6f84-4018-9611-c28ddce14a1d\",\"name\":\"Car Loan\",\"amount\":0},\"monthlyPayment\":null}]}]}";

        LineItemsContainerDm lineItems = JsonUtils.fromJson(lineItemJson, LineItemsContainerDm.class);

        PortfolioDm portfolio = new PortfolioDm();
        portfolio.setLineItems(lineItems);
        portfolio.setCurrencyCode("CAD");

        NetWorthRequestDto request = new NetWorthRequestDto();
        request.setPortfolio(portfolio);
        request.setTargetCurrencyCode("CAD");

        String payload = JsonUtils.toJson(request);

        // ACT
        MvcResult returnValue = this.mockMvc
                .perform(post("/networth").accept(MediaType.APPLICATION_JSON_VALUE)
                        .contentType(MediaType.APPLICATION_JSON_VALUE).content(payload))
                .andExpect(status().isOk()).andReturn();
        String json = returnValue.getResponse().getContentAsString();
        NetWorthResponseDto responseDto = JsonUtils.fromJson(json, NetWorthResponseDto.class);

        // Assert response and portflio
        assertNotNull(responseDto);
        PortfolioDm returned = responseDto.getPortfolio();
        assertNotNull(returned);

        // Assert Currency
        String currencyCode = returned.getCurrencyCode();
        assertNotNull(currencyCode);
        assertEquals("CAD", currencyCode);

        // Assert NetWorth
        NetWorthDm netWorth = returned.getNetWorth();
        assertNotNull(netWorth);
        assertEquals(1292130.00, netWorth.getTotalNetWorth());
        assertEquals(2200427.00, netWorth.getTotalAssets());
        assertEquals(908297.00, netWorth.getTotalLiabilities());

    }

    public static <T> List<T> toList(Class<? extends T> clazz, Collection<?> c) {
        List<T> r = new ArrayList<T>(c.size());
        for (Object o : c)
            r.add(clazz.cast(o));
        return r;
    }
}
