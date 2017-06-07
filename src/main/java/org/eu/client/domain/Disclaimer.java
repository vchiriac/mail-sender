package org.eu.client.domain;


public class Disclaimer {

    private DisclaimerEnum disclaimerEnum;

    public Disclaimer(DisclaimerEnum disclaimerEnum) {
        this.disclaimerEnum = disclaimerEnum;
    }

    public String display() {
        return disclaimerEnum.getName();
    }
}
