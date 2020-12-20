package com.yusuf.learning;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class CipherClient {

    private static final String DATA_TO_PLAY_WITH = "Encrypted-And-Decrypted-Data";
    private static final String KEY_VALUE_TO_BE_USED = "ComplexAlgorithm";

    public static void main(String[] args) throws Exception {

        // Step1: Create Cipher Instance telling what type of encryption algorithm you want to use
        Cipher cipher = Cipher.getInstance("AES");

        // Step2: Create Cipher instance telling what type of encryption algorithm and cipher mode.
        // Since Cipher Block Chaining (CBC) requires a "padding scheme" too, the padding scheme is also provided
        //Cipher cipherWithMode = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Step3: Initializing Cipher : ENCRYPT mode
        Key key = new SecretKeySpec(KEY_VALUE_TO_BE_USED.getBytes(), "AES");

        // Step 4: ENCRYPT data
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(DATA_TO_PLAY_WITH.getBytes());
        System.out.println("Encrypted Data : " + new String(encryptedData));

        // Step 5: DECRYPT data
        // After invoking the doFinal, the cipher object is returned to the state; just after initialization
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println("Decrypted Data : " + new String(decryptedData));


    }

}
