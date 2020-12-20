package com.yusuf.learning;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * In order to verify the hash, we will need to do the both as follows:
 * (a) Decrypt the hashed key which came as an input
 * (b) Generate the hash for the data as an input
 * (c) Compare (a) against (b) to ensure and confirm the data is not changed
 */

public class MACClient {

    private static final String INPUT_DATA = "InputData-MacClient";
    private static final String KEY = "KeyToUsedByMacForEncryptionMDValue";

    public static void main(String[] args) throws Exception {

        // Step1 : Create the Mac instance
        Mac hmacSHA256 = Mac.getInstance("HmacSHA256");

        // Step2 : Create the Key : 'RawBytes' = algorithm
        //Key key = new SecretKeySpec(KEY.getBytes(), "");
        Key key = new SecretKeySpec(KEY.getBytes(), "RawBytes");

        // Step3 : Initialize the Key
        hmacSHA256.init(key);

        // Step4: Calculate the MD for the given input
        byte[] digestedBytes = hmacSHA256.doFinal(INPUT_DATA.getBytes());

        // Print the MD bytes
        for(byte data : digestedBytes) {
            System.out.print(data);
        }
    }
}
