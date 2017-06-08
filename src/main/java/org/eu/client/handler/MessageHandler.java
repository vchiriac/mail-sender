package org.eu.client.handler;

import org.eu.client.container.EmailContainer;
import org.eu.client.exception.InternalException;


public class MessageHandler {

    private int retries;

    public MessageHandler(int retries) {
        this.retries = retries;
    }


    public void handle(EmailContainer container) throws InternalException {
        int count = 1;
        while (count <= retries) {
            try {
                System.out.println(container.getBody().getType() + " "
                        + container.getBody().getContent() + " "
                        + container.getBody().getDisclaimer() + " "
                            + container.displayEncription()
                            + " sent.");
            } catch (Exception e) {
                // handle exception
                if (++count == retries) throw new InternalException("Exception occured in sending email.");
            }
            count++;
        }
    }

}
