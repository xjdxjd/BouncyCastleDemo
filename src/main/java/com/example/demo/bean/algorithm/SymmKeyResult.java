package com.example.demo.bean.algorithm;

import javax.crypto.SecretKey;

public class SymmKeyResult {
    private String key;
    private SecretKey secrekey;
    private String ciphertext;

    public SymmKeyResult() {
    }

    public SymmKeyResult(String key) {
        this.key = key;
    }

    public SymmKeyResult(String key, SecretKey secrekey) {
        this.key = key;
        this.secrekey = secrekey;
    }

    public SymmKeyResult(String key, String ciphertext) {
        this.key = key;
        this.ciphertext = ciphertext;
    }

    public SymmKeyResult(String key, SecretKey secrekey, String ciphertext) {
        this.key = key;
        this.secrekey = secrekey;
        this.ciphertext = ciphertext;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCiphertext() {
        return ciphertext;
    }

    public void setCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public SecretKey getSecrekey() {
        return secrekey;
    }

    public void setSecrekey(SecretKey secrekey) {
        this.secrekey = secrekey;
    }

    @Override
    public String toString() {
        return "SymmKeyResult{" +
                "key='" + key + '\'' +
                ", secrekey=" + secrekey +
                ", ciphertext='" + ciphertext + '\'' +
                '}';
    }
}
