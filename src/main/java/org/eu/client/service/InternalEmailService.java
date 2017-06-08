package org.eu.client.service;

import org.eu.client.domain.DisclaimerEnum;
import org.eu.client.domain.Disclaimer;

public class InternalEmailService extends EmailService {

    //For internal e-mails, disclaimer is OFF

    public InternalEmailService(int retries) {
        super(retries);
        disclaimer = new Disclaimer(DisclaimerEnum.NONE);
    }
}
