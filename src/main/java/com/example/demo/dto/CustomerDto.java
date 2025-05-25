package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDto {

    private Integer customerId;
    private String regionCode;
    private String accountType;
    private String name;
    private String email;
    private String message;
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerDto() {}

    public CustomerDto(Integer customerId, String regionCode, String accountType, String name, String email) {
        this.customerId = customerId;
        this.regionCode = regionCode;
        this.accountType = accountType;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

