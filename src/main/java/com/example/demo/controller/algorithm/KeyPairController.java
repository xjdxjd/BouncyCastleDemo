package com.example.demo.controller.algorithm;

import com.example.demo.bean.Result;
import com.example.demo.bean.algorithm.AKeyPair;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.algorithm.KeyPairUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class KeyPairController extends BaseController
{
    private static String ALG_SM2 = "SM2";
    private static String ALG_RSA = "RSA";

    @PostMapping("/getkeypair/sm2")
    public Result generateKeyPair()
    {
        AKeyPair keyPair = null;
        keyPair = KeyPairUtils.getSM2KeyPair();

        if (ObjectUtils.isEmpty(keyPair) || "" == keyPair.getPubKey())
        {
            return result.failed();
        }
        return result.success("操作成功, 秘钥对已生成！",keyPair);
    }

    @PostMapping("/generate/getkeypair/{stdName}/{time}")
    public Result generateSM2(@PathVariable(value = "stdName")String stdName)
    {

        AKeyPair keyPair = null;
        if(stdName.equals(ALG_SM2))
        {
            keyPair = KeyPairUtils.getSM2KeyPair();
        }
        else if(stdName.equals(ALG_RSA))
        {
            keyPair = KeyPairUtils.getRSAKeyPair();
        }
        else
        {
            return result.failed();
        }

        if (ObjectUtils.isEmpty(keyPair) || "" == keyPair.getPubKey())
        {
            return result.failed();
        }
        return result.success("操作成功, 秘钥对已生成！",keyPair);
    }
}
