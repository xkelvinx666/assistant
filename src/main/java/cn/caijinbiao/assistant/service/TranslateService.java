package cn.caijinbiao.assistant.service;

import com.tencentcloudapi.common.exception.TencentCloudSDKException;

public interface TranslateService {
    String fromText(String text) throws TencentCloudSDKException;
    String fromImage(String data) throws TencentCloudSDKException;
}
