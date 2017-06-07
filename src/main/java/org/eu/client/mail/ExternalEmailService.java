package org.eu.client.mail;

import org.eu.client.domain.DisclaimerEnum;
import org.eu.client.domain.Disclaimer;

public class ExternalEmailService extends EmailService {

    //For external e-mails, disclaimer is ON

    public ExternalEmailService(int retries) {
        super(retries);
        disclaimer = new Disclaimer(DisclaimerEnum.TEXT);
    }

}
