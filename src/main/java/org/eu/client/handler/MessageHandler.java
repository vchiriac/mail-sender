package org.eu.client.handler;

import org.eu.client.container.Email;
import org.eu.client.exception.InternalException;


public class MessageHandler {

    private int retries;

    public MessageHandler(int retries) {
        this.retries = retries;
    }


    public void handle(Email email) throws InternalException {
        int count = 1;
        while (count <= retries) {
            try {
                System.out.println(email.getBody().getType() + " "
                        + email.getBody().getContent() + " "
                        + email.getBody().getDisclaimer() + " "
                            + email.displayEncription()
                            + " sent.");
            } catch (Exception e) {
                // handle exception
                if (++count == retries) throw new InternalException("Exception occured in sending email.");
            }
            count++;
        }
    }

}
