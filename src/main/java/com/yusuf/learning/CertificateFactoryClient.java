package com.yusuf.learning;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

/**
 * (1) java.security.cert.CertificateFactory is capable of creating Java Certificate instances from binary certificate
 * encodings like X.509 (ASN.1 DER)
 * (2) We must create a Java CertificateFactory instance before creating Certificate instances.
 * (3) A CertPath is a chain of certificates where each certificate in the chain is signed by next certificate in chain
 * (4) java.security.cert.CertPath represents a chain of cryptographic identity certificates
 * (Java Certificate objects), where each certificate is the digital signer of the next certificate in the chain
 * (5) The Java CertPath class is typically used to verify an identity certificate along with the certificates of the
 * Certificate Authorities (CAs) that signed the certificate
 */

public class CertificateFactoryClient {

    public static void main(String[] args) throws Exception {

        // Step1: Create the CertificateFactory
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

        // Step2: Creating the Certificate instance
        InputStream certificateInputStream = new FileInputStream("my-x509-certificate.crt");
        Certificate certificate = certificateFactory.generateCertificate(certificateInputStream);

        // Step3: Creating the CertPath from CertificateFactory
        CertPath certPath = certificateFactory.generateCertPath(certificateInputStream);

    }

}
