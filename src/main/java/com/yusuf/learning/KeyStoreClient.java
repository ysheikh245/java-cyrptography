package com.yusuf.learning;

import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;

/**
 * (1) A JAVA keystore is a database that contains keys and represented by java.security.keystore class
 * (2) A KeyStore can be written to disk and read again.
 * (3) The KeyStore as a whole can be protected with a password, and each key entry in the KeyStore can be protected
 *     with its own password.
 * (4) It holds the following types of keys:
 *     - Private Keys
 *     - Public Keys + Certificates
 *     - Secret Keys
 * (5) Before KeyStore instance is used, it must be loaded. You must read data in the Keystore before you can use it
 * (6) Even if there is nothing to load, pass 'null' in the KeyStore.load()
 * (7) We can get the keys from a JKS via its getEntry(). A K/S entry is mapped to an alias which identifies key and
 *     protected with a password. To get to the key, we need keyAlias and password - Step4
 * (8) If you know that the key entry you want to access is a private key, you can cast the KeyStore.Entry instance to a
 *     KeyStore.PrivateKeyEntry
 * (9) After casting to 'KeyStore.PrivateKeyEntry', you can access getPrivateKey(), getCertificate(), getCertificateChain() - Step5
 */

public class KeyStoreClient {

    public static void main(String[] args) throws Exception {

         // Step1: Create the Keystore instance - default type
         KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

         // Step2: Create the Keystore instance - PKCS12 type
         KeyStore pkcs12KeyStore = KeyStore.getInstance("PKCS12"); // creates a keystore of PKCS12 type

         // Step3 : Keystore has to be loaded before use. Loading it from the disk ---
         char[] keyStorePassword = "123abc".toCharArray();
         try(InputStream keyStoreData = new FileInputStream("keystore.jks")){
             keyStore.load(keyStoreData, keyStorePassword);
         }

         // Step3a: If there is nothing to load, still invoke the load with 'null'
         // keyStore.load(null, keyStorePassword); // load a NULL keystore


        // Step4: Getting the Keys via getEntry() method
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection("password".toCharArray());
        KeyStore.Entry keyEntryInKeyStore = keyStore.getEntry("keyAlias", entryPassword);

        // Step5: If we know, that it is a private key - type casted to KeyStore.PrivateKeyEntry
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("keyAlias", entryPassword);
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();
        Certificate certificate = privateKeyEntry.getCertificate();
        Certificate[] certificates = privateKeyEntry.getCertificateChain();

        // Step6: Setting Keys in KeyStore
        keyStore.setEntry("keyAlias", new KeyStore.SecretKeyEntry(null), entryPassword);

        // Step7: Storing the KeyStore in the disk
        try (FileOutputStream keyStoreOutputStream = new FileOutputStream("data/keystore.ks")) {
            keyStore.store(keyStoreOutputStream, keyStorePassword);
        }
    }

}
