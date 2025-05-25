package com.example.demo.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerId implements Serializable {

    private Integer customerId;
    private String regionCode;
    private String accountType;

    public CustomerId() {}

    public CustomerId(Integer customerId, String regionCode, String accountType) {
        this.customerId = customerId;
        this.regionCode = regionCode;
        this.accountType = accountType;
    }

    // Getters and setters

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // hashCode and equals (required for composite key)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerId)) return false;
        CustomerId that = (CustomerId) o;
        return Objects.equals(customerId, that.customerId) &&
               Objects.equals(regionCode, that.regionCode) &&
               Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, regionCode, accountType);
    }
}
