package com.example.demo.controller;

import com.example.demo.bean.Result;

import java.io.UnsupportedEncodingException;
import java.security.spec.InvalidParameterSpecException;

public class BaseController {

    public Result result = new Result();

    public final String ALGORITHM_PATH = "views/algorithm/";

    public final String CERTIFICATE_PATH = "views/certificate/";

    public final static String ALGORITHM_SM2 = "SM2";

    public final static String ALGORITHM_RSA = "RSA";

    public final static String ALGORITHM_AES = "AES";

    public final static String ALGORITHM_DES = "DES";

    public final static String ALGORITHM_MD5 = "MD5";

    public final static String ALGORITHM_SHA1 = "SHA1";

    public final static String ALGORITHM_SHA224 = "SHA224";

    public final static String ALGORITHM_SHA256 = "SHA256";

    public final static String ALGORITHM_SHA384 = "SHA384";

    public final static String ALGORITHM_SHA512 = "SHA512";

    public final  String  SIGNALGORITHRM_SHA256RSA = "1.2.840.113549.1.1.11";

    public final  String  SIGNALGORITHRM_SHA256SM2 = "1.2.840.113549.1.1.11";

    /**********************************************************************************************************/

    public int NOSUCHALGORITHMEXCEPTION_CODE = -2;

    public String NOSUCHALGORITHMEXCEPTION_MESSAGE = "无法找到此算法！";

    public int NOSUCHPADDINGEXCEPTION_CODE = -3;

    public String NOSUCHPADDINGEXCEPTION_MESSAGE = "无法找到这样的填充！";

    public int INVALIDPARAMETERSPECEXCEPTION_CODE = -4;

    public String INVALIDPARAMETERSPECEXCEPTION_MESSAGE = "无法找到有效的参数说明！";

    public int INVALIDALGORITHMPARAMETEREXCEPTION_CODE = -5;

    public String INVALIDALGORITHMPARAMETEREXCEPTION_MESSAGE = "无法找到有效的算法参数！";

    public int INVALIDKEYEXCEPTION_CODE = -6;

    public String INVALIDKEYEXCEPTION_MESSAGE = "无法找到有效的key！";

    public int BADPADDINGEXCEPTION_CODE = -7;

    public String BADPADDINGEXCEPTION_MESSAGE = "此处传递的参数类型错误！";

    public int ILLEGALBLOCKSIZEEXCEPTION_CODE = -8;

    public String ILLEGALBLOCKSIZEEXCEPTION_MESSAGE = "非法块大小异常！";

    public int NOSUCHPROVIDEREXCEPTION_CODE = -9;

    public String NOSUCHPROVIDEREXCEPTION_MESSAGE = "找不到算法包提供者！";

    public int UNSUPPORTEDENCODINGEXCEPTION_CODE = -9;

    public String UNSUPPORTEDENCODINGEXCEPTION_MESSAGE = "找不到算法包提供者！";


}
