package com.example.demo.controller.algorithm;

import com.example.demo.bean.Result;
import com.example.demo.bean.algorithm.SymmKeyResult;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.algorithm.KeyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidParameterSpecException;

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

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return result.error(NOSUCHALGORITHMEXCEPTION_CODE,NOSUCHALGORITHMEXCEPTION_MESSAGE,e);
        } catch (UnsupportedEncodingException e){

            e.printStackTrace();
            return result.error(UNSUPPORTEDENCODINGEXCEPTION_CODE,UNSUPPORTEDENCODINGEXCEPTION_MESSAGE,e);
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

        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return result.error(NOSUCHALGORITHMEXCEPTION_CODE,NOSUCHALGORITHMEXCEPTION_MESSAGE,e);
        } catch (UnsupportedEncodingException e){

            e.printStackTrace();
            return result.error(UNSUPPORTEDENCODINGEXCEPTION_CODE,UNSUPPORTEDENCODINGEXCEPTION_MESSAGE,e);
        }

        session.setAttribute("desKey",symmKey.getSecrekey());
        return result.success(symmKey);
    }

/*====================================================================================================================*/
    /**
     * @Method: generateKeyForAES   DESC:   生成AES密钥
     */
    @PostMapping("/encrypt/aes")
    public Result encryptForAES(@RequestParam("key") String key, @RequestParam("protext") String protext, HttpSession session){
        SecretKey secretkey = (SecretKey) session.getAttribute("aesKey");

        System.out.println("==================eeeeeee==================");
        if(ObjectUtils.isEmpty(secretkey)){
            return result.failed("密钥未生成或生成失败，请重新生成！");
        }
        if(StringUtils.isEmpty(protext) || StringUtils.isEmpty(key)){
            return result.failed("参数为空！");
        }

        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.encryptByAES(ALGORITHM_AES, secretkey, protext);

        } catch (NoSuchPaddingException e){

            e.printStackTrace();
            return result.error(NOSUCHPADDINGEXCEPTION_CODE,NOSUCHPADDINGEXCEPTION_MESSAGE,e);
        } catch (NoSuchAlgorithmException e){

            e.printStackTrace();
            return result.error(NOSUCHALGORITHMEXCEPTION_CODE,NOSUCHALGORITHMEXCEPTION_MESSAGE,e);
        } catch (InvalidParameterSpecException e){

            e.printStackTrace();
            return result.error(INVALIDPARAMETERSPECEXCEPTION_CODE,INVALIDPARAMETERSPECEXCEPTION_MESSAGE,e);
        } catch (InvalidAlgorithmParameterException e){

            e.printStackTrace();
            return result.error(INVALIDALGORITHMPARAMETEREXCEPTION_CODE,INVALIDALGORITHMPARAMETEREXCEPTION_MESSAGE,e);
        } catch (InvalidKeyException e){

            e.printStackTrace();
            return result.error(INVALIDKEYEXCEPTION_CODE,INVALIDKEYEXCEPTION_MESSAGE,e);
        } catch (BadPaddingException e){

            e.printStackTrace();
            return result.error(BADPADDINGEXCEPTION_CODE,BADPADDINGEXCEPTION_MESSAGE,e);
        } catch (IllegalBlockSizeException e){

            e.printStackTrace();
            return result.error(ILLEGALBLOCKSIZEEXCEPTION_CODE,ILLEGALBLOCKSIZEEXCEPTION_MESSAGE,e);
        } catch (NoSuchProviderException e) {

            e.printStackTrace();
            return result.error(NOSUCHPROVIDEREXCEPTION_CODE,NOSUCHPROVIDEREXCEPTION_MESSAGE,e);
        } catch (UnsupportedEncodingException e){

            e.printStackTrace();
            return result.error(UNSUPPORTEDENCODINGEXCEPTION_CODE,UNSUPPORTEDENCODINGEXCEPTION_MESSAGE,e);
        }
        return result.success(symmKey);
    }
    /**
     * @Method: generateKeyForAES   DESC:   生成AES密钥
     */
    @PostMapping("/decrypt/aes")
    public Result decryptForAES(@RequestParam("key") String key,@RequestParam("protext") String protext, HttpSession session){
        SecretKey secretkey = (SecretKey) session.getAttribute("aesKey");

        System.out.println("==================ddddddd==================");
        if(ObjectUtils.isEmpty(secretkey)){
            return result.failed("密钥未生成或生成失败，请重新生成！");
        }
        if(StringUtils.isEmpty(protext) || StringUtils.isEmpty(key)){
            return result.failed("参数为空！");
        }

        SymmKeyResult symmKey = null;
        try {

            symmKey = KeyUtils.decryptByAES(ALGORITHM_AES, secretkey, protext);

        } catch (NoSuchPaddingException e){

            e.printStackTrace();
            return result.error(NOSUCHPADDINGEXCEPTION_CODE,NOSUCHPADDINGEXCEPTION_MESSAGE,e);
        } catch (NoSuchAlgorithmException e){

            e.printStackTrace();
            return result.error(NOSUCHALGORITHMEXCEPTION_CODE,NOSUCHALGORITHMEXCEPTION_MESSAGE,e);
        } catch (InvalidParameterSpecException e){

            e.printStackTrace();
            return result.error(INVALIDPARAMETERSPECEXCEPTION_CODE,INVALIDPARAMETERSPECEXCEPTION_MESSAGE,e);
        } catch (InvalidAlgorithmParameterException e){

            e.printStackTrace();
            return result.error(INVALIDALGORITHMPARAMETEREXCEPTION_CODE,INVALIDALGORITHMPARAMETEREXCEPTION_MESSAGE,e);
        } catch (InvalidKeyException e){

            e.printStackTrace();
            return result.error(INVALIDKEYEXCEPTION_CODE,INVALIDKEYEXCEPTION_MESSAGE,e);
        } catch (BadPaddingException e){

            e.printStackTrace();
            return result.error(BADPADDINGEXCEPTION_CODE,BADPADDINGEXCEPTION_MESSAGE,e);
        } catch (IllegalBlockSizeException e){

            e.printStackTrace();
            return result.error(ILLEGALBLOCKSIZEEXCEPTION_CODE,ILLEGALBLOCKSIZEEXCEPTION_MESSAGE,e);
        } catch (NoSuchProviderException e) {

            e.printStackTrace();
            return result.error(NOSUCHPROVIDEREXCEPTION_CODE,NOSUCHPROVIDEREXCEPTION_MESSAGE,e);
        } catch (UnsupportedEncodingException e){

            e.printStackTrace();
            return result.error(UNSUPPORTEDENCODINGEXCEPTION_CODE,UNSUPPORTEDENCODINGEXCEPTION_MESSAGE,e);
        }
        return result.success(symmKey);
    }

}
