package org.eu.client.main;

import org.eu.client.domain.Email;
import org.eu.client.domain.HtmlEmail;
import org.eu.client.domain.TextEmail;
import org.eu.client.encryption.AES_EncryptionAlgorithm;
import org.eu.client.encryption.DES_EncryptionAlgorithm;
import org.eu.client.encryption.NO_EncriptionAlgorithm;
import org.eu.client.exception.InternalException;
import org.eu.client.mail.EmailService;
import org.eu.client.mail.ExternalEmailService;
import org.eu.client.mail.InternalEmailService;

/**
 * The emails can be sent as plain text or as HTML
 *  - emails which are sent outside the company servers need to be logged and have a disclaimer added to the end.
 *  What's worse, the emails could also be encrypted with AES or DES,
 * or even both at the same time.  Your boss tells you that in case there are problems when sending the emails you
 * should retry the sending operation up to three times.
 *
 * Design a simple client with the accompanying class(es) which you consider to be necessary and write a short program
 * inside the standard void main(String[] args) function that would implement the following scenarios by making use of
 * your class(es):

 ·         sending a plain text email to an outside resource, with a disclaimer added at the end, unencrypted and no retry
 ·         sending an HTML email to an internal server (so without the disclaimer), encrypted with DES, with the retry functionality
 ·         sending an HTML email to an outside resource, with a disclaimer added at the end and encrypted with AES with retries in case of errors
 ·         sending a plain text email to an outside resource and encrypted first with DES and then with AES
 *
 *
 *
 */
public class MainApp {

    private final static int NO_RETRY = 1;
    private final static int WITH_RETRY = 3;

    private EmailService emailService;
    private Email email;

    public static void main(String[] args) {
        try {
            new MainApp().run();
        } catch (InternalException e) {
            e.printStackTrace();
        }
    }

    public void run() throws InternalException {

        //send a plain text email to an outside resource, with a disclaimer added at the end, unencrypted and no retry
        emailService = new ExternalEmailService(NO_RETRY);
        email = new TextEmail();
        email.setEncryptionWith(new NO_EncriptionAlgorithm());
        emailService.send(email);

        //ending an HTML email to an internal server (so without the disclaimer), encrypted with DES, with the retry functionality
        emailService = new InternalEmailService(WITH_RETRY);
        email = new HtmlEmail();
        email.setEncryptionWith(new DES_EncryptionAlgorithm());
        emailService.send(email);

        //sending an HTML email to an outside resource, with a disclaimer added at the end and encrypted with AES with retries in case of errors
        emailService = new ExternalEmailService(WITH_RETRY);
        email = new HtmlEmail();
        email.setEncryptionWith(new AES_EncryptionAlgorithm());
        emailService.send(email);

        //sending a plain text email to an outside resource and encrypted first with DES and then with AES
        emailService = new ExternalEmailService(NO_RETRY);
        email = new HtmlEmail();
        email.setEncryptionWith(new DES_EncryptionAlgorithm(), new AES_EncryptionAlgorithm());
        emailService.send(email);
    }
}
