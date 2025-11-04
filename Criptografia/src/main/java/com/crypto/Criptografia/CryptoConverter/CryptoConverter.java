package com.crypto.Criptografia.CryptoConverter;

import com.crypto.Criptografia.CryptoUtils.CryptoUtils;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.crypto.SecretKey;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {
    private static final String SECRET_PASS_ENV = "APP_CRYPTO_PASSWORD";
    private static final String SALT_ENV = "APP_CRYPTO_SALT_BASE64";

    private final SecretKey key;

    public CryptoConverter(){
        try {
            String pass = System.getenv(SECRET_PASS_ENV);
            String saltBase64 = System.getenv(SALT_ENV);
            if (pass == null || pass.isBlank() || saltBase64 == null || saltBase64.isBlank()){
                throw new IllegalStateException("Variáveis de ambiente criptografadas não definidas." + SECRET_PASS_ENV + " e " + SALT_ENV);
            }
            byte[] salt = java.util.Base64.getDecoder().decode(saltBase64);
            this.key = CryptoUtils.deriveKeyFromPassword(pass.toCharArray(), salt);
        }catch (Exception e){
            throw new RuntimeException("Falha ao inicializar o CryptoConverter", e);
        }
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) return null;

        try {
            return CryptoUtils.encrypt(attribute, key);
        }catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar o atributo");
        }
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        try {
            return CryptoUtils.decrypt(dbData, key);
        }catch (Exception e){
            throw new RuntimeException("Erro ao descriptografar a coluna do banco de dados");
        }
    }
}
