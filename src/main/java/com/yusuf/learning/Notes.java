package com.yusuf.learning;

public class Notes {

    /**
     * (1) JCE (Java Cryptography Extension) is the JAVA cryptography provided by JAVA
     *
     * (2) JCA (Java Cryptography API) is the name for the internal design of the cryptography API
     *
     * (3) Provider: A central class in cryptography API. We need a Provider set to use the crypto api.
     *     If we do not specify a Provider, the default JDK provider is used and it might not support the algorithms
     *     we want to use. In order to do so, we have to use our own crypto provider
     *
     *     public class ProviderExample {
     *          public static void main(String[] args) {
     *              Security.addProvider(new BouncyCastleProvider());
     *          }
     *     }
     *
     * (4) Cipher class represents the crypto algorithm to encrypt or decrypt data.
     *     Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
     *     @see {@link CipherClient}
     *
     * (4a) An encryption mode specifies details about how the algorithm should encrypt data.
     *      Encryption Mode is a technique that is appended to the core encryption algorithm
     *      Modes are often thought of as "add-ons" to encyrption algorithms
     *
     * (5) We must initialize the Cipher instance before using it by calling the init method.
     *     The init method takes 2 parameters:
     *      - Cipher mode (Encryption / Decryption )
     *      - Key for encryption / decryption
     *     For e.g. - cipher.init(Cipher.ENCRYPT_MODE, key); // encrypt mode
     *              - cipher.init(Cipher.DECRYPT_MODE, key);
     *
     * (6) We need a Key to encrypt or decrypt data. 2 types of Keys
     *      - Symmetric  : used for Symmetric encryption. Same key used for encryption and decryption
     *      - Asymmetric : used for ASymmetric encryption. Public and Private Key encryption algorithms
     *     The involved parties need to agree on a key or exchange the key, if the party decrypting the
     *     data is not the same as encrypting the data. This is knows as a 'Key Exchange'
     *
     * (7) Keys used for encryption should be hard to guess. If it is easy to guess, attacker can decrypt data.
     *     We can use 'KeyGenerator' to generate random encryption keys
     *
     *     KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
     *     keyGenerator.init(256);
     *     SecretKey secretKey = keyGenerator.generateKey();
     *
     * (8) Asymmetric encryption algorithms uses a key pair consisting of a public and a private key.
     *
     *      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
     *      KeyPair keyPair = keyPairGenerator.generateKeyPair();
     *
     * (9) Java KeyStore is a database that can contain keys. It is represented by java.security.KeyStore.
     *     A KeyStore can hold the following types of keys:
     *          - Private keys
     *          - Public keys + certificates
     *          - Secret keys
     *
     * (10) The Keytool can
     *          - generate key pairs into a KeyStore file,
     *          - export certificates from, and import certificates into a KeyStore
     *
     * (11) A MessageDigest (hashed value) is calculated from the data before it is encrypted.
     *      It then encrypts both the message and the hash and sends it across the wire.
     * @see {@link MessageDigestClient}
     *
     * (12) java.security.MessageDigest is used to calculate message digests.
     *          MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
     *      We use the instance and invoke update() or digest() to calculate the message digest
     *
     * (13) The MAC class (Message Authentication Code) uses an additional key to encrypt the message digest.
     *      Thus, it needs both the original message and the key to verify the MAC.
     *         Mac mac = Mac.getInstance("HmacSHA256");
     *         SecretKeySpec secretKey = new SecretKeySpec(byte[]);
     *         mac.init(secretKey);
     * @see {@link MACClient}
     *
     * (14) java.security.Signature class is used to sign data digitally. When data is signed, a digital signature is created.
     *      We get a digital signature by creating a MD from data and encrypting that MD with private key of organization.
     *      The encrypted MD is called a digital signature.
     *          Signature signature = Signature.getInstance("SHA256WithDSA");
     *          signature.initSign(keyPair.getPrivate());
     *
     * (15) To verify the Signature, we initialize java.security.Signature in verify mode
     *          Signature signature = Signature.getInstance("SHA256WithDSA");
     *          signature.initVerify(keyPair.getPublic());
     * @see {@link SignatureClient}
     *
     * (16) References
     *      - https://www.codebyamir.com/blog/java-developers-guide-to-ssl-certificates
     *      - http://tutorials.jenkov.com/java-cryptography/index.html
     */

    public static void main(String[] args) {
        new Notes();
    }

}
