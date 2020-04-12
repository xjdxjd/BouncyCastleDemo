package com.example.demo.utils.algorithm;

import org.bouncycastle.crypto.digests.*;
import sun.security.provider.SHA;

public class DigestUtils {


    public static byte[] md5Digest(String info) {

        MD5Digest md5Digest = new MD5Digest();
        md5Digest.update(info.getBytes(),0, info.getBytes().length);

        byte[] digestByte = new byte[md5Digest.getDigestSize()];
        md5Digest.doFinal(digestByte, 0);

        return digestByte;
    }

    public static byte[] sha1Digest(String info) {

        SHA1Digest sha1Digest = new SHA1Digest();
        sha1Digest.update(info.getBytes(), 0, info.getBytes().length);

        byte[] digestByte = new byte[sha1Digest.getDigestSize()];
        sha1Digest.doFinal(digestByte, 0);

        return digestByte;
    }

    public static byte[] sha224Digest(String info) {

        SHA224Digest sha224Digest = new SHA224Digest();
        sha224Digest.update(info.getBytes(), 0, info.getBytes().length);

        byte[] digestByte = new byte[sha224Digest.getDigestSize()];
        sha224Digest.doFinal(digestByte, 0);

        return digestByte;
    }
    public static byte[] sha384Digest(String info) {

        SHA384Digest sha384Digest = new SHA384Digest();
        sha384Digest.update(info.getBytes(), 0, info.getBytes().length);

        byte[] digestByte = new byte[sha384Digest.getDigestSize()];
        sha384Digest.doFinal(digestByte, 0);

        return digestByte;
    }
    public static byte[] sha256Digest(String info) {

        SHA256Digest sha256Digest = new SHA256Digest();
        sha256Digest.update(info.getBytes(), 0, info.getBytes().length);

        byte[] digestByte = new byte[sha256Digest.getDigestSize()];
        sha256Digest.doFinal(digestByte, 0);

        return digestByte;
    }

    public static byte[] sha512Digest(String info) {

        SHA512Digest sha512Digest = new SHA512Digest();
        sha512Digest.update(info.getBytes(), 0, info.getBytes().length);

        byte[] digestByte = new byte[sha512Digest.getDigestSize()];
        sha512Digest.doFinal(digestByte, 0);

        return digestByte;
    }

}
