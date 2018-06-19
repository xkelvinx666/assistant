package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.model.Translate;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

public interface TranslateService {
    void addTranslate(String source, String target, long type, long isp);
    Translate getTranslate(String source, long type, long isp) throws TencentCloudSDKException;
}
