package com.example.demo.controller.algorithm;

import com.example.demo.bean.Result;
import com.example.demo.bean.algorithm.SymmKeyResult;
import com.example.demo.common.Constants;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.algorithm.KeyUtils;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpSession;
import java.security.Security;

@Controller
@ResponseBody
public class KeyController extends BaseController {

    /**
     * @Method: generateKeyForAES   DESC:   生成AES密钥
     */
    @GetMapping("/generatekey/aes")
    public Result generateKeyForAES(){
        SymmKeyResult symmKey = new SymmKeyResult();
        try {
            //  添加密码模块BC包支持
            Security.addProvider(new BouncyCastleProvider());
            
            //  初始化密钥生成器
            KeyGenerator keyGenerator = KeyGenerator.getInstance(Constants.ALGORITHM_AES, Constants.PACKAGE_BC);
            keyGenerator.getProvider();
            keyGenerator.init(Constants.ALGORITHM_AES_LENGTH);
            //  获取密钥
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();
    
            //  转换为Base64字符串
            String desKey = Base64.toBase64String(encoded);
            symmKey.setKey(desKey);
    
            return result.success(symmKey);
        } catch (Exception ex){
            ex.printStackTrace();
            return result.error();
        }
    }

    /**
     * @Method: generateKeyForDES   DESC:   生成DES密钥
     */
    @GetMapping("/generatekey/des")
    public Result generateKeyForDES(){
        SymmKeyResult symmKey = new SymmKeyResult();
        try {
            //  添加密码模块BC包支持
            Security.addProvider(new BouncyCastleProvider());
            
            //  初始化密钥生成器
            KeyGenerator keyGenerator = KeyGenerator.getInstance(Constants.ALGORITHM_DES, Constants.PACKAGE_BC);
            keyGenerator.getProvider();
            keyGenerator.init(Constants.ALGORITHM_DES_LENGTH);
            
            //  获取密钥
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();
            
            //  转换为Base64字符串
            String desKey = Base64.toBase64String(encoded);
            symmKey.setKey(desKey);
    
            return result.success(symmKey);
        } catch (Exception ex){
            ex.printStackTrace();
            return result.error(ex.getMessage());
        }
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
    public Result encryptForDES(@RequestParam("key") String key, @RequestParam("protext") String protext){
        SymmKeyResult symmKey = new SymmKeyResult();
        try {
            symmKey = KeyUtils.encryptByDES(key, protext);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result.success(symmKey);
    }
    /**
     * @Method: decryptForDES   DESC:   DES解密
     */
    @PostMapping("/decrypt/des")
    public Result decryptForDES(@RequestParam("key") String key, @RequestParam("ciptext") String ciptext){
        SymmKeyResult symmKey = new SymmKeyResult();
        try {
            symmKey = KeyUtils.decryptByDES(key, ciptext);

        } catch (Exception e){
            e.printStackTrace();
        }
        return result.success(symmKey);
    }

}
