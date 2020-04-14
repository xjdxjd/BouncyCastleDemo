package com.example.demo;

import org.bouncycastle.util.encoders.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void AESEncyptAndDecypt(){
        String dataString = "这是一段摘要示例明文：全书共十二章，讲述了关于宇宙本性的最前沿知识";

        System.out.println("data："+ dataString);

        try {
        /*============================================[  密  钥  ]============================================*/
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //设置密钥长度
            kgen.init(128);
            //生成密钥
            SecretKey skey = kgen.generateKey();
            byte[] key = skey.getEncoded();
            System.out.print("密钥：");
            for (byte b:key) {
                System.out.printf("%x",b);
            }
            System.out.println();
            System.out.println("密钥："+ new Base64().toBase64String(key));
//            byte[] iv = new byte[16];
//            Arrays.fill(iv, (byte) 0x00);
//            AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
//            params.init(new IvParameterSpec(iv));

            /*============================================[  加  密  ]============================================*/
            Cipher cipher = Cipher.getInstance("AES", "BC");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); // 生成加密解密需要的Key
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] enbytes = cipher.doFinal(dataString.getBytes());
            System.out.print("密文：");
            for (byte b:enbytes) {
                System.out.printf("%x",b);
            }
            System.out.println();
            System.out.println("密文："+ new String(new Base64().encode(enbytes)));

        /*============================================[  解  密  ]============================================*/
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] debytes = cipher.doFinal(enbytes);


            System.out.print("明文：");
            for (byte b:debytes) {
                System.out.printf("%x",b);
            }
            System.out.println();
            System.out.println("明文："+ new String(debytes));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
