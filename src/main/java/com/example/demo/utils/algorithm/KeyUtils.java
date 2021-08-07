package com.example.demo.utils.algorithm;

import com.example.demo.bean.algorithm.SymmKeyResult;
import com.example.demo.common.Constants;
import com.example.demo.utils.CommonUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
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
    public static SymmKeyResult encryptByDES(String keyString, String proText) throws Exception {
        //  Base64 处理工具
        Base64 base64 = new Base64();

        //  添加密码模块BC包支持
        Security.addProvider(new BouncyCastleProvider());

        //  根据传入的密钥字符串，生成DES密钥    1. 获取密钥工厂实例. 2. 获取密钥规范. 3. 获取密钥KEY
        SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.ALGORITHM_DES);
        DESKeySpec desKeySpec = new DESKeySpec(base64.decode(keyString));
        Key key = factory.generateSecret(desKeySpec);

        //  获取Cipher类，初始化为加密模式
        Cipher cipher = Cipher.getInstance(Constants.DES_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        //  获取密文
        byte[] cipbytes = cipher.doFinal(proText.getBytes());

        // 密文转换为字符串
        String ciptext = new String(base64.encode(cipbytes));

        SecretKey secretKey = new SecretKeySpec(base64.decode(keyString), Constants.ALGORITHM_DES);
        SymmKeyResult symmKey = new SymmKeyResult(keyString, secretKey, ciptext);
        return symmKey;
    }

    /**
     * @Method: decryptByDES   DESC:   DES解密
     */
    public static SymmKeyResult decryptByDES(String keyString, String ciptext) throws Exception{
        //  Base64 处理工具
        Base64 base64 = new Base64();

        //  添加密码模块BC包支持
        Security.addProvider(new BouncyCastleProvider());

        //  根据传入的密钥字符串，生成DES密钥类    1. 获取密钥工厂实例. 2. 获取密钥规范. 3. 获取密钥KEY
        SecretKeyFactory factory = SecretKeyFactory.getInstance(Constants.ALGORITHM_DES);
        DESKeySpec desKeySpec = new DESKeySpec(base64.decode(keyString));
        Key key = factory.generateSecret(desKeySpec);

        //  获取Cipher类，初始化为加密模式
        Cipher cipher = Cipher.getInstance(Constants.DES_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, key);

        //  获取明文
        byte[] probytes = cipher.doFinal(ciptext.getBytes());

        // 密文转换为字符串
        String protext = new String(base64.encode(probytes));

        SecretKey secretKey = new SecretKeySpec(base64.decode(keyString), Constants.ALGORITHM_DES);
        SymmKeyResult symmKey = new SymmKeyResult(keyString, secretKey, protext);
        return symmKey;
    }
}
