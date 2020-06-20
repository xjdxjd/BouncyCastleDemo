package com.example.demo.bean.algorithm;


public class DigestResult {

    private String algName;
    private String digestContent;

    public DigestResult() {
    }

    public DigestResult(String digestContent) {
        this.digestContent = digestContent;
    }

    public DigestResult(String algName, String digestContent) {
        this.algName = algName;
        this.digestContent = digestContent;
    }

    public String getAlgName() {
        return algName;
    }

    public void setAlgName(String algName) {
        this.algName = algName;
    }

    public String getDigestContent() {
        return digestContent;
    }

    public void setDigestContent(String digestContent) {
        this.digestContent = digestContent;
    }

    @Override
    public String toString() {
        return "DigestResult{" +
                "algName='" + algName + '\'' +
                ", digestContent='" + digestContent + '\'' +
                '}';
    }

}
