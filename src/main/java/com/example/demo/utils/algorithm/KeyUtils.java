package com.example.demo.utils.algorithm;

import com.example.demo.bean.algorithm.SymmKeyResult;
import com.example.demo.utils.CommonUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

public class KeyUtils {


    private final static String PROVIDER = "BC";
    private final static String ALGORITHM_AES = "AES";
    private final static String ALGORITHM_DES = "DES";
//    private final static AlgorithmParameters iv = CommonUtils.generateIV("AES");

    static{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    }
    /**
     * @Method: generateKey   DESC:   生成对称密钥 --用于反显
     */
    public static SymmKeyResult generateKey( int length,String algName) throws NoSuchAlgorithmException, UnsupportedEncodingException{

        SymmKeyResult symmKey = null;
        //  创建密钥生成器
        KeyGenerator keyGenerate = KeyGenerator.getInstance(algName);
        //  初始化密钥声生成器
        keyGenerate.init(length);
        //  生成密钥
        SecretKey secretKey = keyGenerate.generateKey();
        //  密钥转码    byte[] --> 16进制字符串
        byte[] keybytes = secretKey.getEncoded();
        String key = new Base64().toBase64String(keybytes);

        symmKey = new SymmKeyResult(key,secretKey);
        return symmKey;
    }

/*====================================================================================================================*/
    /**
     * @Method: encryptByAES   DESC:   AES加密
     */
    public static SymmKeyResult encryptByAES(SecretKey secretkey, String protext) throws Exception{

        SymmKeyResult symmKey = null;
        String encodeKey = new String(Base64.encode(secretkey.getEncoded()));

        Cipher cipher = Cipher.getInstance(ALGORITHM_AES,PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);

        byte[] cipbytes = cipher.doFinal(protext.getBytes());

        String ciptext = new String(new Base64().encode(cipbytes));

        symmKey = new SymmKeyResult(encodeKey, secretkey, ciptext);

        return symmKey;
    }

    /**
     * @Method: decryptByAES   DESC:   AES解密
     */
    public static SymmKeyResult decryptByAES(SecretKey secretkey, String ciptext) throws Exception {

        SymmKeyResult symmKey = null;
        String encodeKey = new String(Base64.encode(secretkey.getEncoded()));
        Cipher cipher = Cipher.getInstance(ALGORITHM_AES,PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, secretkey);

        byte[] decode = new Base64().decode(ciptext);
        byte[] cipbytes = cipher.doFinal(decode);

        String dectext = new String(cipbytes);

        symmKey = new SymmKeyResult(encodeKey,secretkey,dectext);

        return symmKey;
    }

    /**
     * @Method: encryptByDES   DESC:   DES加密
     */
    public static SymmKeyResult encryptByDES(SecretKey secretkey, String protext) throws Exception {
        SymmKeyResult symmKey = null;
        String encodeKey = new String(Base64.encode(secretkey.getEncoded()));

        Cipher cipher = Cipher.getInstance(ALGORITHM_DES,PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, secretkey);

        byte[] cipbytes = cipher.doFinal(protext.getBytes());

        String ciptext = new String(new Base64().encode(cipbytes));

        symmKey = new SymmKeyResult(encodeKey, secretkey, ciptext);


        return symmKey;
    }

    /**
     * @Method: decryptByDES   DESC:   DES解密
     */
    public static SymmKeyResult decryptByDES(SecretKey secretkey, String ciptext) throws Exception{
    SymmKeyResult symmKey = null;
        String encodeKey = new String(Base64.encode(secretkey.getEncoded()));
        Cipher cipher = Cipher.getInstance(ALGORITHM_DES,PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, secretkey);

        byte[] decode = new Base64().decode(ciptext);
        byte[] cipbytes = cipher.doFinal(decode);

        String dectext = new String(cipbytes);

        symmKey = new SymmKeyResult(encodeKey,secretkey,dectext);


        return symmKey;
    }
}
