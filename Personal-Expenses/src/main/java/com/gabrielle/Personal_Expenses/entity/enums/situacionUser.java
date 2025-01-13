package com.gabrielle.Personal_Expenses.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum situacionUser {
    ACTIVE("A", "Active"),
    INACTIVE("I", "Inactive"),
    PENDING("P", "Pending");

    private String code;
    private String description;

    private situacionUser(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static situacionUser contentValue(String code) {
        if (code.equals("A")) {
            return ACTIVE;
        } 
        else if(code.equals("I")) {
            return INACTIVE;
        } 
        else if(code.equals("P")) {
            return PENDING;
        }
        else {
            return null;
        }
    }
}
