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
    public void shouldReturnLineItemsCorrectly() throws Exception {
        this.mockMvc.perform(get("/networth")).andExpect(status().isOk());
    }

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
        MvcResult getLineItems = this.mockMvc.perform(get("/networth")).andReturn();
        String lineItemJson = getLineItems.getResponse().getContentAsString();

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
