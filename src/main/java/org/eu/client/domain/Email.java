package org.eu.client.domain;


import org.eu.client.encryption.EncryptionAlgorithm;

import java.util.ArrayList;
import java.util.List;

public abstract class Email {

    protected Disclaimer disclaimer;
    private List<EncryptionAlgorithm> encryptionAlgorithms = new ArrayList<EncryptionAlgorithm>();

    public abstract String getType();

    public String getDisclaimer() {
        return disclaimer.display();
    }

    public void setDisclaimer(Disclaimer disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setEncryptionWith(EncryptionAlgorithm... encryptionAlgorithm) {
        for (EncryptionAlgorithm e : encryptionAlgorithm) {
            encryptionAlgorithms.add(e);
        }
    }

    public String displayEncription() {
        StringBuilder sb = new StringBuilder();
        for (EncryptionAlgorithm e : encryptionAlgorithms) {
            sb.append("Encrypted with: " + e.getEncryption() + " ");
        }
        return sb.toString();
    }
}
