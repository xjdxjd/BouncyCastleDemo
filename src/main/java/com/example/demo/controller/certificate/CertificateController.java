package com.example.demo.controller.certificate;

import com.example.demo.bean.Result;
import com.example.demo.bean.certificate.ICertificate;
import com.example.demo.controller.BaseController;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @DESC:   证书操作Controller
 * @ClassName: CertificateController
 */
@Controller
@RequestMapping("/cert")
public class CertificateController extends BaseController
{
    private static String ALG_SM2 = "SM2";
    private static String ALG_RSA = "RSA";
    private static String ALG_SM2_ID = "SM2";
    private static String ALG_RSA_ID = "RSA";

    @PostMapping("/generateCert")
    @ResponseBody
    public Result generateCertificate(@RequestParam("stdName") String stdName, @RequestParam("formData") String formData)
    {
        String sss = "{\"issuerName\":\"DN=ROOTCA\",\"subjectName\":\"DN=TESTCA\",\"algorithm\":\"0\",\"notBeforeDate\":\"2020-04-05\",\"notAfterDate\":\"1\"}";
        JSONPObject jsonpObject = JSON.parseObject(formData);
        System.out.println("formData = " + formData);
        System.out.println("certInfo = " + certInfo.toString());

        ICertificate iCertificate = new ICertificate();
        if (ALG_SM2.equals(stdName))
        {
            System.out.println("stdName = " + stdName);
        }
        else
        {
            System.out.println("stdName = " + stdName);
        }

        return result.success();
    }
}
