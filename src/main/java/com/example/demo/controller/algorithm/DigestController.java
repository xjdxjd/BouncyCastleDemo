package com.example.demo.controller.algorithm;

import com.example.demo.bean.Result;
import com.example.demo.bean.algorithm.DigestResult;
import com.example.demo.controller.BaseController;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.algorithm.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("digestController")
public class DigestController extends BaseController {

    @PostMapping("/digest/md5/{info}")
    @ResponseBody
    public Result digestforMD5 (@PathVariable("info") String info) {

        if (StringUtils.isEmpty(info)) {
            result.failed("明文信息为空！");
        }
        byte[] digestByte =  DigestUtils.md5Digest(info);
        String digestContent = CommonUtils.byteToHexString(digestByte);

        if (StringUtils.isEmpty(digestContent) || digestContent == "") {
            result.failed("摘要失败！");
        }
        DigestResult digestResult = new DigestResult(ALGORITHM_MD5, digestContent);
        return result.success(digestResult);

    }

    @PostMapping("/digest/sha1/{info}")
    @ResponseBody
    public Result digestforSHA1 (@PathVariable("info") String info) {

        if (StringUtils.isEmpty(info)) {
            result.failed("明文信息为空！");
        }
        byte[] digestByte =  DigestUtils.sha1Digest(info);
        String digestContent = CommonUtils.byteToHexString(digestByte);

        if (StringUtils.isEmpty(digestContent) || digestContent == "") {
            result.failed("摘要失败！");
        }

        DigestResult digestResult = new DigestResult(ALGORITHM_SHA1, digestContent);

        return result.success(digestResult);
    }

    @PostMapping("/digest/sha224/{info}")
    @ResponseBody
    public Result digestforSHA224 (@PathVariable("info") String info) {

        if (StringUtils.isEmpty(info)) {
            result.failed("明文信息为空！");
        }
        byte[] digestByte =  DigestUtils.sha224Digest(info);
        String digestContent = CommonUtils.byteToHexString(digestByte);

        if (StringUtils.isEmpty(digestContent) || digestContent == "") {
            result.failed("摘要失败！");
        }

        DigestResult digestResult = new DigestResult(ALGORITHM_SHA224, digestContent);

        return result.success(digestResult);
    }

    @PostMapping("/digest/sha256/{info}")
    @ResponseBody
    public Result digestforSHA256 (@PathVariable("info") String info) {

        if (StringUtils.isEmpty(info)) {
            result.failed("明文信息为空！");
        }
        byte[] digestByte =  DigestUtils.sha256Digest(info);
        String digestContent = CommonUtils.byteToHexString(digestByte);

        if (StringUtils.isEmpty(digestContent) || digestContent == "") {
            result.failed("摘要失败！");
        }

        DigestResult digestResult = new DigestResult(ALGORITHM_SHA256, digestContent);

        return result.success(digestResult);
    }

    @PostMapping("/digest/sha384/{info}")
    @ResponseBody
    public Result digestforSHA384 (@PathVariable("info") String info) {

        if (StringUtils.isEmpty(info)) {
            result.failed("明文信息为空！");
        }
        byte[] digestByte =  DigestUtils.sha384Digest(info);
        String digestContent = CommonUtils.byteToHexString(digestByte);

        if (StringUtils.isEmpty(digestContent) || digestContent == "") {
            result.failed("摘要失败！");
        }

        DigestResult digestResult = new DigestResult(ALGORITHM_SHA384, digestContent);

        return result.success(digestResult);
    }

    @PostMapping("/digest/sha512/{info}")
    @ResponseBody
    public Result digestforSHA512 (@PathVariable("info") String info) {

        if (StringUtils.isEmpty(info)) {
            result.failed("明文信息为空！");
        }
        byte[] digestByte =  DigestUtils.sha512Digest(info);
        String digestContent = CommonUtils.byteToHexString(digestByte);

        if (StringUtils.isEmpty(digestContent) || digestContent == "") {
            result.failed("摘要失败！");
        }

        DigestResult digestResult = new DigestResult(ALGORITHM_SHA512, digestContent);

        return result.success(digestResult);
    }
}
