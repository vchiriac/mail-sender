package org.eu.client.builder;

public class EmailMessage {


    private String from;
    private String to;
    private String subject;
    private String content;

    private EmailMessage() {
    }

    public static Builder builder() {
        return new EmailMessage.Builder();
    }

    public static class Builder {
        private EmailMessage instance = new EmailMessage();

        public Builder() {
        }

        public Builder from(String from) {
            instance.from = from;
            return this;
        }

        public Builder to(String to) {
            instance.to = to;
            return this;
        }

        public Builder subject(String subject) {
            instance.subject = subject;
            return this;
        }

        public Builder content(String content) {
            instance.content = content;
            return this;
        }

        public EmailMessage build() {
            return instance;
        }
    }
}