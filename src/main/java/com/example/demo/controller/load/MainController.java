package com.example.demo.controller.load;

import com.example.demo.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController extends BaseController {



    @GetMapping({"index","/","index.html"})
    public String toIndex(){
        return "index";
    }


    @GetMapping("digest")
    public String toDigest(){
        return ALGORITHM_PATH+"digest";
    }

    @GetMapping("symmKey")
    public String toSymmKey(){
        return ALGORITHM_PATH+"symmkey";
    }

    @GetMapping("asymmetric")
    public String toAsymmetric(){
        return ALGORITHM_PATH+"asymmetric";
    }

    @GetMapping("infoDigest")
    public String toInfoDigest(){
        return ALGORITHM_PATH+"informationdigest";
    }

    @GetMapping("symmKeyEncAndDec")
    public String toSymmkeyEncAndDec(){
        return ALGORITHM_PATH+"symmkey_encanddec";
    }

    @GetMapping("asymmKeyEncAndDec")
    public String toAsymmkeyEncAndDec(){
        return ALGORITHM_PATH+"asymmkey_encanddec";
    }

    @GetMapping("SM2")
    public String toSM2(){
        return ALGORITHM_PATH+"SM2";
    }
    @GetMapping("SM3")
    public String toSM3(){
        return ALGORITHM_PATH+"SM3";
    }
    @GetMapping("SM4")
    public String toSM4(){
        return ALGORITHM_PATH+"SM4";
    }



    @GetMapping("certGenerate")
    public String toCertGenerate(){
        return CERTIFICATE_PATH+"cert_generate";
    }

    @GetMapping("certParse")
    public String toCertParse(){
        return CERTIFICATE_PATH+"cert_parse";
    }

    @GetMapping("certChainGenerate")
    public String toCertChainGenerate(){
        return CERTIFICATE_PATH+"certchain_generate";
    }

    @GetMapping("certChainParse")
    public String toCertChainParse(){
        return CERTIFICATE_PATH+"certchain_parse";
    }

    @GetMapping("crlGenerate")
    public String toCrlGenerate(){
        return CERTIFICATE_PATH+"crl_generate";
    }

    @GetMapping("crlParse")
    public String toCrlParse(){
        return CERTIFICATE_PATH+"crl_parse";
    }
}
