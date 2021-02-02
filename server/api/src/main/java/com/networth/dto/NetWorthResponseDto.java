package com.networth.dto;

import com.networth.svc.models.NetWorthDm;

public class NetWorthResponseDto {

    private NetWorthDm netWorthDm;

    private String currencyCode;

    private String currencySymbol;

    public NetWorthDm getNetWorthDm() {
        return this.netWorthDm;
    }

    public void setNetWorthDm(NetWorthDm netWorthDm) {
        this.netWorthDm = netWorthDm;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    @Override
    public String toString() {
        return "{" + " netWorthDm='" + getNetWorthDm() + "'" + ", currencyCode='" + getCurrencyCode() + "'"
                + ", currencySymbol='" + getCurrencySymbol() + "'" + "}";
    }

}
