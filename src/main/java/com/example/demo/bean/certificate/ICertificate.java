package com.example.demo.bean.certificate;

import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.jce.interfaces.ECPrivateKey;
import org.bouncycastle.jce.interfaces.ECPublicKey;

import java.util.Date;

/**
 * @DESC:
 * @ClassName: ICertificate
 */
public class ICertificate
{
    private String issuerDN;
    private String subjectDN;
    private String algorithm;
    private Date notBeforeDate;
    private Date notAfterDate;
    private String publicKey;
    private String privateKey;
    private String certData;

    private ECPublicKey ecPublicKey;
    private ECPrivateKey ecPrivateKey;
    private Certificate certificate;

    public ICertificate() {}

    public ICertificate(String issuerDN, String subjectDN,
                        String algorithm, Date notBeforeDate,
                        Date notAfterDate, String publicKey,
                        String privateKey, String certData,
                        ECPublicKey ecPublicKey, ECPrivateKey ecPrivateKey,
                        Certificate certificate)
    {
        this.issuerDN = issuerDN;
        this.subjectDN = subjectDN;
        this.algorithm = algorithm;
        this.notBeforeDate = notBeforeDate;
        this.notAfterDate = notAfterDate;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.certData = certData;
        this.ecPublicKey = ecPublicKey;
        this.ecPrivateKey = ecPrivateKey;
        this.certificate = certificate;
    }

    public String getIssuerDN() {
        return issuerDN;
    }

    public void setIssuerDN(String issuerDN) {
        this.issuerDN = issuerDN;
    }

    public String getSubjectDN() {
        return subjectDN;
    }

    public void setSubjectDN(String subjectDN) {
        this.subjectDN = subjectDN;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public Date getNotBeforeDate() {
        return notBeforeDate;
    }

    public void setNotBeforeDate(Date notBeforeDate) {
        this.notBeforeDate = notBeforeDate;
    }

    public Date getNotAfterDate() {
        return notAfterDate;
    }

    public void setNotAfterDate(Date notAfterDate) {
        this.notAfterDate = notAfterDate;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getCertData() {
        return certData;
    }

    public void setCertData(String certData) {
        this.certData = certData;
    }

    public ECPublicKey getEcPublicKey() {
        return ecPublicKey;
    }

    public void setEcPublicKey(ECPublicKey ecPublicKey) {
        this.ecPublicKey = ecPublicKey;
    }

    public ECPrivateKey getEcPrivateKey() {
        return ecPrivateKey;
    }

    public void setEcPrivateKey(ECPrivateKey ecPrivateKey) {
        this.ecPrivateKey = ecPrivateKey;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "ICertificate{" +
                "IssuerDN='" + issuerDN + '\'' +
                ", subjectDN='" + subjectDN + '\'' +
                ", algorithm='" + algorithm + '\'' +
                ", notBeforeDate=" + notBeforeDate +
                ", notAfterDate=" + notAfterDate +
                ", publicKey='" + publicKey + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", certData='" + certData + '\'' +
                '}';
    }
}
