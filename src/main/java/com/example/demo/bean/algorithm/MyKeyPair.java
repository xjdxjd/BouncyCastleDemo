package com.example.demo.bean.algorithm;

public class MyKeyPair {
    private String priKey;
    private String pubKey;

    public MyKeyPair() {
    }

    public MyKeyPair(String priKey, String pubKey) {
        this.priKey = priKey;
        this.pubKey = pubKey;
    }

    public String getPriKey() {
        return priKey;
    }

    public void setPriKey(String priKey) {
        this.priKey = priKey;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    @Override
    public String toString() {
        return "MyKeyPair{" +
                "priKey='" + priKey + '\'' +
                "\n pubKey='" + pubKey + '\'' +
                '}';
    }
}
