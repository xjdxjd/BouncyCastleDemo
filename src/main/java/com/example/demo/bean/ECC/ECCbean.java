package com.example.demo.bean.ECC;

import lombok.Data;

@Data
public class ECCbean {

    //  明文
    private String plaintext;
    private byte[] plaintextByte;

    //  密文
    private String ciphertext;
    private byte[] ciphertextByte;

    //  摘要
    private String digest;

    //  椭圆曲线点-X
    private String ECCpoint_X;

    //  椭圆曲线点-Y
    private String ECCpoint_Y;

    //  SM3 摘要值
    private String sm3Digest;

}
