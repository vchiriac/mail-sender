package org.eu.client.builder;


import org.eu.client.container.EmailContainer;
import org.eu.client.encryption.EncryptionAlgorithm;

public interface EmailBuilder {
    public EmailBuilder from(String fromAddress);

    public EmailBuilder to(String toAddress);

    public EmailBuilder subject(String subject);

    public EmailBuilder body(EmailBody body);

    EmailBuilder encryptedWith(EncryptionAlgorithm... encryptionAlgorithm);

    public EmailContainer build();
}
