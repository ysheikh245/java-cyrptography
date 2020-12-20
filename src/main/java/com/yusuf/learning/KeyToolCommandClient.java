package com.yusuf.learning;

/**
 * (1) Keytool - a command line tool which generates public key / private key pairs and store them in a Java KeyStore
 * (2) Generate Key Pair
 *      - Generating a public key / private key pair is one of the most common tasks to use the Java Keytool for.
 *      - The generated key pair is inserted into a Java KeyStore file as a self signed key pair.
 * (3) Export Certificate
 *      - The Java Keytool can also export certificates stored in a KeyStore.
 * (4) Import Certificate
 *      - The Java Keytool can also import certificates into a KeyStore.
 * (5) List KeyStore Entries
 *      - To list the entries in a Java KeyStore you can use the Keytool -list command.
 * (6) Delete KeyStore Entry
 *      - The Keytool has a command that can delete a key entry in a Java KeyStore.
 * (7) Generate a Certificate Request
 *      - The Java Keytool can generate a certificate request using the -certreq command.
 *      - A certificate request is a request for a CA to create a public certificate for your organization.
 *      - Once generated, the certificate request should be sent to the CA you want to create a certificate
 *      for you (e.g. Verisign, Thawte, or some other CA).
 *
 */

public class KeyToolCommandClient {

    public static void main(String[] args) {

    }

}
