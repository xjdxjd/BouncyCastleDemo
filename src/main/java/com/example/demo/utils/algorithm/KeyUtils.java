package com.example.demo.utils.algorithm;

import com.example.demo.bean.algorithm.SymmKeyResult;
import com.example.demo.utils.CommonUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;
public class KeyUtils {


    private final static String PROVIDER = "BC";
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
        byte[] encoded = secretKey.getEncoded();
        String key = new String(encoded,"utf-8");

        symmKey = new SymmKeyResult(key,secretKey);
        return symmKey;
    }

    /**
     * @Method: generateKey   DESC:   生成对称密钥 --用于加密
     */

    public static SecretKey generateSecretKey( int length,String algName) throws NoSuchAlgorithmException{
        //  创建密钥生成器
        KeyGenerator keyGenerate = KeyGenerator.getInstance(algName);
        //  初始化密钥声生成器
        keyGenerate.init(length);
        //  生成密钥
        SecretKey secretKey = keyGenerate.generateKey();
        return secretKey;
    }

/*====================================================================================================================*/
    /**
     * @Method: encryptByAES   DESC:   AES加密
     */
    public static SymmKeyResult encryptByAES(String algName, SecretKey secrekey, String protext)
            throws  NoSuchPaddingException, NoSuchAlgorithmException,NoSuchProviderException,
            InvalidParameterSpecException, InvalidAlgorithmParameterException, UnsupportedEncodingException,
            InvalidKeyException, BadPaddingException,IllegalBlockSizeException {

        SymmKeyResult symmKey = null;

        Security.addProvider(new BouncyCastleProvider());
        AlgorithmParameters iv = CommonUtils.generateIV(algName);

        Cipher cipher = Cipher.getInstance(algName,PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, secrekey, iv);
        byte[] cipbytes = cipher.doFinal(protext.getBytes());

        byte[] encodeKey = Base64.encode(secrekey.getEncoded());
//        String key = .encodeToString(secrekey.getEncoded());
        byte[] ciptext = Base64.encode(cipbytes);
        symmKey = new SymmKeyResult(new String(encodeKey,"utf-8"),secrekey,new String(ciptext));
        return symmKey;
    }

    /**
     * @Method: decryptByAES   DESC:   AES解密
     */
    public static SymmKeyResult decryptByAES(String algName, SecretKey secrekey, String decrypt)
            throws NoSuchPaddingException, NoSuchAlgorithmException,NoSuchProviderException,
            InvalidParameterSpecException, InvalidAlgorithmParameterException, UnsupportedEncodingException,
            InvalidKeyException, BadPaddingException,IllegalBlockSizeException {

        byte[] debyte = Base64.decode(decrypt);
        SymmKeyResult symmKey = null;

        Security.addProvider(new BouncyCastleProvider());
        AlgorithmParameters iv = CommonUtils.generateIV(algName);

        Cipher cipher = Cipher.getInstance(algName,PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, secrekey, iv);
        byte[] cipbytes = cipher.doFinal(debyte);
//        System.out.println("====================================================================");
//        System.out.println("cipbytes.toString():");
//        System.out.println(cipbytes.toString());
//        StringBuffer ss = new StringBuffer();
//        for (byte b:cipbytes) {
//            ss.append(b);
//        }
//        System.out.println("ss.toString():");
//        System.out.println(ss.toString());
//        System.out.println("CommonUtils.byteToHexString(cipbytes):");
//        System.out.println(CommonUtils.byteToHexString(cipbytes));
//        System.out.println("encoder64.encodeToString(cipbytes):");
//        System.out.println(encoder64.encodeToString(cipbytes));
//        System.out.println("====================================================================");


        byte[] encodeKey = Base64.encode(secrekey.getEncoded());
        byte[] ciptext = Base64.encode(cipbytes);
        symmKey = new SymmKeyResult(new String(encodeKey,"utf-8"),secrekey,new String(ciptext));
        return symmKey;
    }
}
