package com.acabouomony.tokenization.util;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class EncryptionUtil {

    private static final String PASSWORD = "secret-key"; // Ideally from environment
    private static final String SALT = "12345678"; // Random salt for encryption

    public static String encrypt(String plainText) {
        TextEncryptor encryptor = Encryptors.text(PASSWORD, SALT);
        return encryptor.encrypt(plainText);
    }

    public static String decrypt(String encryptedText) {
        TextEncryptor encryptor = Encryptors.text(PASSWORD, SALT);
        return encryptor.decrypt(encryptedText);
    }
}
