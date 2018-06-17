package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.exception.CheckException;
import cn.caijinbiao.assistant.properties.SignTokenProperties;
import cn.caijinbiao.assistant.service.SignService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignTokenProperties signTokenProperties;

    /**
     * 验证签名
     */
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数进行字典序排序
        List<String> params = new ArrayList<>();
        params.add(signTokenProperties.getToken());
        params.add(timestamp);
        params.add(nonce);
        Collections.sort(params);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String content = StringUtils.join(params, ',').replaceAll(",", "");
        String sha1Str = DigestUtils.sha1Hex(content);
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return sha1Str.toUpperCase().equals(signature.toUpperCase());
    }

    /**
     * 非微信官方请求，记录恶意请求地址
     */
    public void isIllegalSignature() throws CheckException {
        throw new CheckException("请求验证失败");
    }
}
