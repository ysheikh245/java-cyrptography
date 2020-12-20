package com.yusuf.learning;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

/**
 * A digital signature is a message digest encrypted with a private key of a private / public key pair.
 * Anyone in possession of the public key can verify the digital signature.
 *
 * On the producer side, we pass the data and the privateKey of the organization
 * On the consumer side, we pass the data and the publicKey of the organization
 *
 */

public class SignatureClient {

    private static final String DATA_TO_BE_SIGNED = "DataToBeSigned";
    private static KeyPair keyPair;

    public static void main(String[] args) throws Exception {

        //Step1: Create the java.security.Signature object
        Signature signature = Signature.getInstance("SHA256WithDSA");

        //Step2: Initialize the object for signing the data - passing the private key of the organization
        signature.initSign(getKeyPair().getPrivate());

        //Step3: Supply the data
        signature.update(DATA_TO_BE_SIGNED.getBytes());
        
        //Step4: Sign the data and create the signedData
        byte[] signedData = signature.sign();

        //Step5: On the other side, create the java.security.Signature object for verification
        Signature signature2 = Signature.getInstance("SHA256WithDSA");

        //Step6: Initialize the object for verifying the data - passing the public key of the organization
        signature2.initVerify(getKeyPair().getPublic());

        //Step7: Supply the data
        signature2.update(DATA_TO_BE_SIGNED.getBytes());

        //Step8: Verify the signedData
        boolean verifiedFlag = signature2.verify(signedData);

        System.out.println("Signature Verified : " + verifiedFlag);


    }

    private static KeyPair getKeyPair() throws Exception {
        if(keyPair == null) {
            keyPair = KeyPairGenerator.getInstance("DSA").generateKeyPair();
        }
        return keyPair;
    }

}
