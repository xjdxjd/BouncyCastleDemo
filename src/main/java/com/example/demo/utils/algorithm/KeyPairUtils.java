package com.example.demo.utils.algorithm;

import com.example.demo.bean.algorithm.AKeyPair;

import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.KeyPair;

import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.util.Base64;

public class KeyPairUtils {

    private final static Base64.Encoder encoder64 = Base64.getEncoder();

    public static KeyPair generateKeyPair(){

        try{

            // 获取SM2椭圆曲线的参数
            ECGenParameterSpec sm2Spec = new ECGenParameterSpec("sm2p256v1");

            // 获取一个椭圆曲线类型的密钥对生成器
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());

            // 使用SM2参数初始化生成器
            kpg.initialize(sm2Spec);

            // 使用SM2的算法区域初始化密钥生成器
            kpg.initialize(sm2Spec, new SecureRandom());

            // 获取密钥对
            KeyPair keyPair = kpg.generateKeyPair();
            return keyPair;

        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public static AKeyPair getSM2KeyPair(){

        AKeyPair keypair = new AKeyPair();
        try{

            // 获取SM2椭圆曲线的参数
            ECGenParameterSpec sm2Spec = new ECGenParameterSpec("sm2p256v1");

            // 获取一个椭圆曲线类型的密钥对生成器
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());

            // 使用SM2参数初始化生成器
            kpg.initialize(sm2Spec);

            // 使用SM2的算法区域初始化密钥生成器
            kpg.initialize(sm2Spec, new SecureRandom());

            // 获取密钥对
            KeyPair keyPair = kpg.generateKeyPair();

            //组装自定义类
            keypair.setPubKey(encoder64.encodeToString(keyPair.getPublic().getEncoded()));
            keypair.setPriKey(encoder64.encodeToString(keyPair.getPrivate().getEncoded()));
            return keypair;

        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }

    public static AKeyPair getRSAKeyPair() {

        AKeyPair keypair = new AKeyPair();

        try {
            //  创建keyPair生成器
            RSAKeyPairGenerator rsaKeyPairGenerator = new RSAKeyPairGenerator();
            RSAKeyGenerationParameters rsaKeyGenerationParameters = new RSAKeyGenerationParameters(BigInteger.valueOf(3),
                    new SecureRandom(), 1024, 25);

            //  初始化生成器
            rsaKeyPairGenerator.init(rsaKeyGenerationParameters);

            //  获取可输出的公私钥
            AsymmetricCipherKeyPair KeyPair = rsaKeyPairGenerator.generateKeyPair();
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(KeyPair.getPublic());
            PrivateKeyInfo privateKeyInfo = PrivateKeyInfoFactory.createPrivateKeyInfo(KeyPair.getPrivate());

            //  拿出ASN1Primitive
            ASN1Primitive pubKey_ASN1 = subjectPublicKeyInfo.toASN1Primitive();
            ASN1Primitive priKey_ASN1 = privateKeyInfo.toASN1Primitive();

            //  组装MyKeyPair
            keypair.setPubKey(encoder64.encodeToString(pubKey_ASN1.getEncoded()));
            keypair.setPriKey(encoder64.encodeToString(priKey_ASN1.getEncoded()));

            return keypair;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
