package com.example.demo.controller.certificate;

import com.example.demo.bean.certificate.CRLData;
import com.example.demo.bean.Result;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.CommonUtils;
import org.bouncycastle.jce.provider.X509CRLParser;
import org.bouncycastle.x509.util.StreamParsingException;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.*;

@Controller
public class CRLController extends BaseController {

    @PostMapping(value="/crl/parse")
    @ResponseBody
    public Result parse(@RequestParam(value = "file", required = false) MultipartFile crlFile, HttpServletRequest request){

        if(ObjectUtils.isEmpty(crlFile)){
            return result.failed();
        }
        CRLData crlData = new CRLData();
        InputStream ins = null;
        X509CRL crl = null;
        try {

            ins = crlFile.getInputStream();
            X509CRLParser parser = new X509CRLParser();
            parser.engineInit(ins);

            crl = (X509CRL) parser.engineRead();

            crlData.setIssuer(crl.getIssuerDN().getName());
            if (crl.getSigAlgOID().equals(SIGNALGORITHRM_SHA256RSA)) {
                crlData.setAlgName("RSA");
            }
            if (crl.getSigAlgOID().equals(SIGNALGORITHRM_SHA256SM2)) {
                crlData.setAlgName("SM2");

            }
            crlData.setType(crl.getType());
            List<X509CRLEntry> revokedCerts = new ArrayList<>();

            Set<? extends X509CRLEntry> revokedCertificates = crl.getRevokedCertificates();
            Iterator<? extends X509CRLEntry> iterator = revokedCertificates.iterator();
            revokedCerts.add(iterator.next());
//            int index = 0;
            while (iterator.hasNext()) {
                revokedCerts.add(iterator.next());
//                if(index > 10){
//                    break;
//                }
//                index++;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            crlData.setData(CommonUtils.inputStream2String(ins));
            crlData.setRevokedCerts(revokedCerts);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (StreamParsingException e) {
            e.printStackTrace();
        } finally {
            try {
                ins.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(ObjectUtils.isEmpty(crlData) || StringUtils.isEmpty(crlData.getIssuer())){
            return result.failed();
        }
        System.out.println("上传成功了");
        request.getSession().setAttribute("crldata",crlData);
        return result.success(crlData);
    }

    @GetMapping(value="/crl/loadData")
    @ResponseBody
    public Result loadData(HttpServletRequest request){
        CRLData crlData = (CRLData)request.getSession().getAttribute("crldata");
        return result.success(crlData);
    }
}
