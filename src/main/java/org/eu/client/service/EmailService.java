package org.eu.client.service;


import org.eu.client.container.EmailContainer;
import org.eu.client.domain.Disclaimer;
import org.eu.client.exception.InternalException;
import org.eu.client.handler.MessageHandler;

public abstract class EmailService {

    protected Disclaimer disclaimer;

    private int retries;

    public EmailService(int retries) {
        this.retries = retries;
    }

    public void send(EmailContainer container) throws InternalException {
        container.getBody().setDisclaimer(disclaimer);
        new MessageHandler(retries).handle(container);
    }
}
