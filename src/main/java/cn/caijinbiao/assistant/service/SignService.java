package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.exception.CheckException;

public interface SignService {
    boolean checkSignature(String signature, String timestamp, String nonce);
    void isIllegalSignature() throws CheckException;
}
