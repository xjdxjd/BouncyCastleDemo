package com.example.demo.controller.algorithm;

import com.example.demo.bean.algorithm.MyKeyPair;
import com.example.demo.bean.Result;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.algorithm.KeyPairUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@Controller
public class KeyPairController extends BaseController {

    @PostMapping("/generate/getkeypair/{stdName}/{time}")
    @ResponseBody
    public Result generateSM2KeyPair(@PathVariable(value = "stdName")String stdName){
        MyKeyPair keyPair = null;
        if(ALGORITHM_SM2.equals(stdName)){

            keyPair = KeyPairUtils.getSM2KeyPair();
        }
        if(ALGORITHM_RSA.equals(stdName)){
            keyPair = KeyPairUtils.getRSAKeyPair();
        }
        if (ObjectUtils.isEmpty(keyPair) || "" == keyPair.getPubKey()){
            return result.failed();
        }
        return result.success("操作成功, 秘钥对已生成！",keyPair);
    }
}
