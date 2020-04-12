package com.example.demo.bean.certificate;

import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.List;

public class CRLData {

    private String Issuer;
    private String algName;
    private String type;
    private Date thisUpdate;
    private Date nextUpdate;
    private String data;
    private List<X509CRLEntry> revokedCerts;

    public CRLData() {
    }

    public CRLData(String issuer, String algName, String type, Date thisUpdate, Date nextUpdate, String data, List<X509CRLEntry> revokedCerts) {
        Issuer = issuer;
        this.algName = algName;
        this.type = type;
        this.thisUpdate = thisUpdate;
        this.nextUpdate = nextUpdate;
        this.data = data;
        this.revokedCerts = revokedCerts;
    }

    public String getIssuer() {
        return Issuer;
    }

    public void setIssuer(String issuer) {
        Issuer = issuer;
    }

    public String getAlgName() {
        return algName;
    }

    public void setAlgName(String algName) {
        this.algName = algName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getThisUpdate() {
        return thisUpdate;
    }

    public void setThisUpdate(Date thisUpdate) {
        this.thisUpdate = thisUpdate;
    }

    public Date getNextUpdate() {
        return nextUpdate;
    }

    public void setNextUpdate(Date nextUpdate) {
        this.nextUpdate = nextUpdate;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<X509CRLEntry> getRevokedCerts() {
        return revokedCerts;
    }

    public void setRevokedCerts(List<X509CRLEntry> revokedCerts) {
        this.revokedCerts = revokedCerts;
    }

    @Override
    public String toString() {
        return "CRLData{" +
                "Issuer='" + Issuer + '\'' +
                ", algName='" + algName + '\'' +
                ", type='" + type + '\'' +
                ", thisUpdate=" + thisUpdate +
                ", nextUpdate=" + nextUpdate +
                ", data='" + data + '\'' +
                ", revokedCerts=" + revokedCerts +
                '}';
    }
}
