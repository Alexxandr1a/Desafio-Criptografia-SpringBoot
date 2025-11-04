package com.crypto.Criptografia.Crypto;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerateSalt {
    public static void main(String[] args) {
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        System.out.println("Seu SALT Base64 é: " + saltBase64);
    }
}
