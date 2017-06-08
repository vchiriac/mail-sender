package org.eu.client.container;

import org.eu.client.builder.EmailBody;
import org.eu.client.builder.EmailBuilder;
import org.eu.client.encryption.EncryptionAlgorithm;

import java.util.ArrayList;
import java.util.List;


public final class Email {

    private final List<EncryptionAlgorithm> encryptionAlgorithms;
    private final String fromAddress;
    private final List<String> toAddresses;
    private final String subject;
    private final EmailBody body;

    protected Email(Builder builder) {
        this.fromAddress = builder.fromAddress;
        this.toAddresses = builder.toAddresses;
        this.subject = builder.subject;
        this.body = builder.body;
        this.encryptionAlgorithms = builder.encryptionAlgorithms;
    }


    public static EmailBuilder builder() {
        return new Builder();
    }

    public EmailBody getBody() {
        return this.body;
    }

    public final String displayEncription() {
        StringBuilder sb = new StringBuilder();
        for (EncryptionAlgorithm e : encryptionAlgorithms) {
            sb.append("Encrypted with: " + e.getEncryption() + " ");
        }
        return sb.toString();
    }

    public final static class Builder implements EmailBuilder {

        private List<EncryptionAlgorithm> encryptionAlgorithms;
        private String fromAddress;
        private List<String> toAddresses;
        private String subject;
        private EmailBody body;


        public Builder() {
            this.fromAddress = null;
            this.toAddresses = new ArrayList<>();
            this.subject = "";
            this.body = EmailBody.fromString("");
            this.encryptionAlgorithms = new ArrayList<>();

        }


        @Override
        public EmailBuilder from(String fromAddress) {
            this.fromAddress = fromAddress;
            return this;
        }

        @Override
        public EmailBuilder to(String toAddress) {
            this.toAddresses.add(toAddress);
            return this;
        }

        @Override
        public EmailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }

        @Override
        public EmailBuilder body(EmailBody body) {
            this.body = body;
            return this;
        }

        @Override
        public EmailBuilder encryptedWith(EncryptionAlgorithm... encryptionAlgorithm) {
            for (EncryptionAlgorithm e : encryptionAlgorithm) {
                this.encryptionAlgorithms.add(e);
            }
            return this;
        }

        @Override
        public Email build() {

            if (this.fromAddress == null) {
                throw new IllegalStateException("From address cannot be null or empty!");
            }
            if (this.toAddresses.isEmpty()) {
                throw new IllegalArgumentException("At least one TO: address is required!");
            }

            return new Email(this);
        }
    }
}
