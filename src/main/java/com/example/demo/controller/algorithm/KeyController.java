package com.example.demo.controller.algorithm;

import com.example.demo.bean.Result;
import com.example.demo.bean.algorithm.SymmKeyResult;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.algorithm.KeyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
@ResponseBody
public class KeyController extends BaseController {

    /**
     * @Method: generateKeyForAES   DESC:   生成AES密钥
     */
    @GetMapping("/generatekey/aes/{length}")
    public Result generateKeyForAES(@PathVariable("length") int length, HttpSession session){
        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.generateKey(length,ALGORITHM_AES);

        } catch (Exception e){

            e.printStackTrace();
        }
        session.setAttribute("aesKey",symmKey.getSecrekey());
        return result.success(symmKey);
    }

    /**
     * @Method: generateKeyForDES   DESC:   生成DES密钥
     */
    @GetMapping("/generatekey/des/{length}")
    public Result generateKeyForDES(@PathVariable("length") int length, HttpSession session){
        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.generateKey(length, ALGORITHM_DES);

        } catch (Exception e){
            e.printStackTrace();
        }

        session.setAttribute("desKey",symmKey.getSecrekey());
        return result.success(symmKey);
    }

    /*====================================================================================================================*/
    /**
     * @Method: encryptForAES   DESC:   AES加密
     */
    @PostMapping("/encrypt/aes")
    public Result encryptForAES(@RequestParam("key") String key, @RequestParam("protext") String protext, HttpSession session){

        SecretKey secretkey = (SecretKey) session.getAttribute("aesKey");
        if(ObjectUtils.isEmpty(secretkey)){
            return result.failed("AES密钥未生成或生成失败，无法加密，请重新生成！");
        }
        if(StringUtils.isEmpty(protext) || StringUtils.isEmpty(key)){
            return result.failed("参数为空！");
        }
        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.encryptByAES(secretkey, protext);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result.success(symmKey);
    }
    /**
     * @Method: decryptForAES   DESC:   AES解密
     */
    @PostMapping("/decrypt/aes")
    public Result decryptForAES(@RequestParam("key") String key,@RequestParam("ciptext") String ciptext, HttpSession session){

        if(StringUtils.isEmpty(ciptext) || StringUtils.isEmpty(key)){
            return result.failed("参数为空！");
        }
        SecretKey secretkey = (SecretKey) session.getAttribute("aesKey");
        if(ObjectUtils.isEmpty(secretkey)){
            return result.failed("AES密钥未生成或生成失败,无法解密，请重新生成！");
        }
        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.decryptByAES(secretkey, ciptext);

        } catch (Exception e){
            e.printStackTrace();
        }
        return result.success(symmKey);
    }

    /*====================================================================================================================*/
    /**
     * @Method: encryptForDES   DESC:   DES加密
     */
    @PostMapping("/encrypt/des")
    public Result encryptForDES(@RequestParam("key") String key, @RequestParam("protext") String protext, HttpSession session){

        if(StringUtils.isEmpty(protext) || StringUtils.isEmpty(key)){

            return result.failed("参数为空！");
        }
        SecretKey secretkey = (SecretKey) session.getAttribute("desKey");
        if(ObjectUtils.isEmpty(secretkey)){
            return result.failed("DES密钥未生成或生成失败，无法加密，请重新生成！");
        }
        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.encryptByDES(secretkey, protext);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result.success(symmKey);
    }
    /**
     * @Method: decryptForDES   DESC:   DES解密
     */
    @PostMapping("/decrypt/des")
    public Result decryptForDES(@RequestParam("key") String key,@RequestParam("ciptext") String ciptext, HttpSession session){

        SecretKey secretkey = (SecretKey) session.getAttribute("desKey");
        if(ObjectUtils.isEmpty(secretkey)){
            return result.failed("DES密钥未生成或生成失败,无法解密，请重新生成！");
        }
        if(StringUtils.isEmpty(ciptext) || StringUtils.isEmpty(key)){
            return result.failed("参数为空！");
        }
        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.decryptByDES(secretkey, ciptext);

        } catch (Exception e){
            e.printStackTrace();
        }
        return result.success(symmKey);
    }

}
