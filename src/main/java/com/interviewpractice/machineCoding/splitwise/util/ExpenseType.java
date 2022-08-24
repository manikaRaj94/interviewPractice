package com.interviewpractice.machineCoding.splitwise.util;

public enum ExpenseType {
    EQUAL("E"),
    EXACT("X"),
    PERCENT("P");

    private String value;

    public String getValue() {
        return value;
    }

    ExpenseType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
