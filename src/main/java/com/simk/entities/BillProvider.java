package com.simk.entities;

public class BillProvider extends Bill{
    private String ProviderName;

    public String getProviderName() {
        return ProviderName;
    }

    public void setProviderName(String providerName) {
        ProviderName = providerName;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s+"," +
                "ProviderName='" + ProviderName + '\'';
    }
}
