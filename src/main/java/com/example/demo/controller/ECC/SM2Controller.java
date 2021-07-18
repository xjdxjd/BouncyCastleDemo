package com.example.demo.controller.ECC;

import com.example.demo.bean.ECC.ECCbean;
import com.example.demo.bean.Result;
import com.example.demo.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sm2")
public class SM2Controller extends BaseController {

    @PostMapping("/encrypt")
    public Result encrypt () {
        ECCbean sm2bean = new ECCbean();
        return result.success(sm2bean);
    }
}
