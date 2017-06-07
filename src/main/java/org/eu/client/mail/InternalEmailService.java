package org.eu.client.mail;

import org.eu.client.DisclaimerEnum;
import org.eu.client.domain.Disclaimer;

public class InternalEmailService extends EmailService {

    //For internal e-mails, disclaimer is OFF

    public InternalEmailService(int retries) {
        super(retries);
        disclaimer = new Disclaimer(DisclaimerEnum.NONE);
    }
}
