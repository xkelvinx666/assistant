package cn.caijinbiao.assistant.util;

import cn.caijinbiao.assistant.exception.CheckException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SignUtil {
    private final static String TOKEN = "connor";

    /**
     * 验证签名
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数进行字典序排序
        List<String> params = new ArrayList<>();
        params.add(TOKEN);
        params.add(timestamp);
        params.add(nonce);
        Collections.sort(params);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String content = StringUtils.join(params, ',').replaceAll(",","");
        String sha1Str = DigestUtils.sha1Hex(content);
        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
        return sha1Str.toUpperCase().equals(signature.toUpperCase());
    }

    /**
     * 非微信官方请求，记录恶意请求地址
     */
    public static void isIllegalSignature() throws CheckException {
        throw new CheckException("请求验证失败");
    }
}
