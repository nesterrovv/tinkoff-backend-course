package edu.project1.gallows.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cryptographer {

    private static final String SALT = "waitingForUnlockUSDT";

    private Cryptographer() {}

    public static String encrypt(String stringForEncrypt) {
        String hexString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(SALT.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = md.digest(stringForEncrypt.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hexString = sb.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hexString;
    }

}
