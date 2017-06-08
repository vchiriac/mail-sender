package org.eu.client.service;


import org.eu.client.container.Email;
import org.eu.client.domain.Disclaimer;
import org.eu.client.exception.InternalException;
import org.eu.client.handler.MessageHandler;

public abstract class EmailService {

    protected Disclaimer disclaimer;

    private int retries;

    public EmailService(int retries) {
        this.retries = retries;
    }

    public void send(Email email) throws InternalException {
        email.getBody().setDisclaimer(disclaimer);
        new MessageHandler(retries).handle(email);
    }
}
