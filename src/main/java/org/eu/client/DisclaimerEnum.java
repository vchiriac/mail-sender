package org.eu.client;


public enum DisclaimerEnum {
    NONE(""),
    TEXT("This is a disclaimer");

    private String name;

    private DisclaimerEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
