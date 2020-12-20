package com.yusuf.learning;

import java.io.ByteArrayInputStream;
import java.security.MessageDigest;

/**
 * Algorithm Name
 * MD2
 * MD5
 * SHA-1
 * SHA-256
 * SHA-384
 * SHA-512
 *
 * Not all MD algorithms are equally secure.
 * It is recommended to use SHA-256 or higher to get the highest possible amount of security
 */

public class MessageDigestClient {

    private static final String INPUT_DATA = "InputData-MessageDigestClient";

    public static void main(String[] args) throws Exception {

        // Step1: Create the MD object
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] digestedData = messageDigest.digest(INPUT_DATA.getBytes());

        // print the array
        for(byte data : digestedData) {
            System.out.print(data);
        }

    }

}
