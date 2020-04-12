package com.example.demo.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class CommonUtils {

    /**
     * 获取时间戳
     */
    public long getTimestamp () {

        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间
     */
    public Date getCurrentDate() {

        return new Date();
    }

    /**
     * 格式化时间
     */
    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    /**
     * 解码返回byte
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }


    /**
     * 编码返回字符串
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 编码返回字符串
     */
    public static String inputStream2String (InputStream ins) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = ins.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    /**
     * @Method: byteToHexString   DESC:   byte转换为16进制字符串
     */
    public static String byteToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex = Integer.toHexString(bytes[i]);
            if (strHex.length() > 3) {
                sb.append(strHex.substring(6));
            } else {
                if (strHex.length() < 2) {
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return sb.toString();
    }

    /**
     * @Method: generateIV   DESC:   生成算法参数
     */
    public static AlgorithmParameters generateIV(String algName) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        //iv 为一个 16 字节的数组，这里采用和 iOS 端一样的构造方法，数据全为0
        byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00);
        AlgorithmParameters params = AlgorithmParameters.getInstance(algName);
        params.init(new IvParameterSpec(iv));
        return params;
    }
}
