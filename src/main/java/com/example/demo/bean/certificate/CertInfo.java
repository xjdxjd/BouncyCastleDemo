package com.example.demo.bean.certificate;

import java.util.Date;

/**
 * @DESC:
 * @ClassName: CertInfo
 */
public class CertInfo
{
    private String issuerName;
    private String subjectName;
    private Integer algorithm;
    private Date notBeforeDate;
    private Date notAfterDate;

    public CertInfo() {
    }

    public CertInfo(String issuerName, String subjectName, Integer algorithm, Date notBeforeDate, Date notAfterDate) {
        this.issuerName = issuerName;
        this.subjectName = subjectName;
        this.algorithm = algorithm;
        this.notBeforeDate = notBeforeDate;
        this.notAfterDate = notAfterDate;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Integer algorithm) {
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

    @Override
    public String toString() {
        return "CertInfo{" +
                "issuerName='" + issuerName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", algorithm=" + algorithm +
                ", notBeforeDate=" + notBeforeDate +
                ", notAfterDate=" + notAfterDate +
                '}';
    }
}
