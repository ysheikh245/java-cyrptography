package com.yusuf.learning;

import java.security.KeyPairGenerator;

/**
 * (1) We obtain a KeyPair instance from a JAVA keystore or a KeyPairGenerator - @see {@link KeyPairGenerator}
 * (2) javax.crypto.KeyGenerator is used to generate symmetric encryption keys
 * (3) java.security.KeyPairGenerator is used to generate asymmetric encryption / decryption key pairs
 *     An asymmetric key pair consists of two keys. The public key is typically used to encrypt data.
 *     The private key is used to decrypt data encrypted with the first key
 *
 *
 *
 */

public class KeysClient {

    public static void main(String[] args) {

        /**
         * KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
         * keyGenerator.init(keyBitSize);
         * SecretKey secretKey = keyGenerator.generateKey();
         *
         *
         * KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
         * keyPairGenerator.initialize(2048);
         * KeyPair keyPair = keyPairGenerator.generateKeyPair();
         * PublicKey publicKey   = keyPair.getPublicKey();
         * PrivateKey privateKey = keyPair.getPrivateKey();
         *
         *

         *
         */

    }


}
