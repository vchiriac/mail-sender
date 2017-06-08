package org.eu.client.builder;

import org.eu.client.domain.Disclaimer;

public interface EmailBodyBuilder {

    public EmailBodyBuilder content(String body);

    public EmailBodyBuilder type(String type);

    EmailBodyBuilder disclaimer(Disclaimer disclaimer);

    public EmailBody build();

}
