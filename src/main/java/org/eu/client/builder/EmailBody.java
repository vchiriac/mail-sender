package org.eu.client.builder;


import org.eu.client.domain.Disclaimer;

public final class EmailBody {

    private final String content;
    private final String type;

    private Disclaimer disclaimer;

    protected EmailBody(Builder builder) {
        this.content = builder.content;
        this.type = builder.type;
        this.disclaimer = builder.disclaimer;
    }

    public static EmailBodyBuilder builder() {
        return new EmailBody.Builder();
    }

    public static EmailBody fromString(String body) {
        return builder().content(body).build();
    }

    public String getContent() {
        return this.content;
    }

    public String getType() {
        return this.type;
    }

    public String getDisclaimer() {
        return this.disclaimer.display();
    }

    public void setDisclaimer(Disclaimer disclaimer) {
        this.disclaimer = disclaimer;
    }

    public static class Builder implements EmailBodyBuilder {

        private String content;
        private String type;
        private Disclaimer disclaimer;

        @Override
        public EmailBodyBuilder content(String body) {
            this.content = body;
            return this;
        }

        @Override
        public EmailBodyBuilder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public EmailBodyBuilder disclaimer(Disclaimer disclaimer) {
            this.disclaimer = disclaimer;
            return this;
        }

        @Override
        public EmailBody build() {
            return new EmailBody(this);
        }
    }

}
