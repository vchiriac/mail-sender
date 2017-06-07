package org.eu.client.domain;

import org.eu.client.DisclaimerEnum;


public class Disclaimer {

    private DisclaimerEnum disclaimerEnum;

    public Disclaimer(DisclaimerEnum disclaimerEnum) {
        this.disclaimerEnum = disclaimerEnum;
    }

    public String display() {
        return disclaimerEnum.getName();
    }
}
