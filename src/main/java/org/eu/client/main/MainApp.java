package org.eu.client.main;

import org.eu.client.builder.EmailBody;
import org.eu.client.container.EmailContainer;
import org.eu.client.domain.*;
import org.eu.client.encryption.AES_EncryptionAlgorithm;
import org.eu.client.encryption.DES_EncryptionAlgorithm;
import org.eu.client.exception.InternalException;
import org.eu.client.service.EmailService;
import org.eu.client.service.ExternalEmailService;
import org.eu.client.service.InternalEmailService;

/**
 * The emails can be sent as plain text or as HTML
 * - emails which are sent outside the company servers need to be logged and have a disclaimer added to the end.
 * What's worse, the emails could also be encrypted with AES or DES,
 * or even both at the same time.  Your boss tells you that in case there are problems when sending the emails you
 * should retry the sending operation up to three times.
 * <p/>
 * Design a simple client with the accompanying class(es) which you consider to be necessary and write a short program
 * inside the standard void main(String[] args) function that would implement the following scenarios by making use of
 * your class(es):
 * <p/>
 * ·         sending a plain text email to an outside resource, with a disclaimer added at the end, unencrypted and no retry
 * ·         sending an HTML email to an internal server (so without the disclaimer), encrypted with DES, with the retry functionality
 * ·         sending an HTML email to an outside resource, with a disclaimer added at the end and encrypted with AES with retries in case of errors
 * ·         sending a plain text email to an outside resource and encrypted first with DES and then with AES
 */
public class MainApp {


    public static void main(String[] args) {
        try {
            new MainApp().run();
        } catch (InternalException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() throws InternalException {

        //send a plain text email to an outside resource, with a disclaimer added at the end, unencrypted and no retry
        EmailService emailService = new ExternalEmailService(RetryTimes.NO_RETRY);
        EmailBody body = EmailBody.builder()
                                  .type(EmailType.TEXT)
                                  .content("text/plain")
                                   .build();
        emailService.send(EmailContainer.builder()
                                        .from("aa")
                                        .to("bb")
                                        .subject("hey")
                                        .body(body)
                                        .build());

        //ending an HTML email to an internal server (so without the disclaimer), encrypted with DES, with the retry functionality
        emailService = new InternalEmailService(RetryTimes.WITH_RETRY);
        body = EmailBody.builder()
                .type(EmailType.HTML)
                        .content("text/html; charset=utf-8")
                .build();
        emailService.send(EmailContainer.builder()
                .from("aa")
                        .to("bb")
                .subject("hey")
                .body(body)
                        .encryptedWith(new DES_EncryptionAlgorithm())
                        .build());

        //sending an HTML email to an outside resource, with a disclaimer added at the end and encrypted with AES with retries in case of errors
        emailService = new ExternalEmailService(RetryTimes.WITH_RETRY);
        body = EmailBody.builder()
                .type(EmailType.HTML)
                        .content("text/html; charset=utf-8")
                .build();
        emailService.send(EmailContainer.builder()
                .from("aa")
                        .to("bb")
                .subject("hey")
                .body(body)
                        .encryptedWith(new AES_EncryptionAlgorithm())
                        .build());

        //sending a plain text email to an outside resource and encrypted first with DES and then with AES
        emailService = new InternalEmailService(RetryTimes.NO_RETRY);
        body = EmailBody.builder()
                .type(EmailType.TEXT)
                        .content("text/plain")
                .build();
        emailService.send(EmailContainer.builder()
                .from("aa")
                        .to("bb")
                .subject("hey")
                .body(body)
                .encryptedWith(new DES_EncryptionAlgorithm(), new AES_EncryptionAlgorithm())
                        .build());

    }
}
