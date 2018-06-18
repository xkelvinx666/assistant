package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.properties.TencentApiProperties;
import cn.caijinbiao.assistant.service.TranslateService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.ImageTranslateRequest;
import com.tencentcloudapi.tmt.v20180321.models.ImageTranslateResponse;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateRequest;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TranslateServiceImpl implements TranslateService {
    @Autowired
    TencentApiProperties tencentApiProperties;

    private TmtClient getClient() {
        Credential cred = new Credential(tencentApiProperties.getSecretId(), tencentApiProperties.getSecretKey());
        TmtClient client = new TmtClient(cred, tencentApiProperties.getRegion());
        return client;
    }

    @Override
    public String fromText(String text) throws TencentCloudSDKException {
        TmtClient client = getClient();
        TextTranslateRequest req = new TextTranslateRequest();
        req.setSource(tencentApiProperties.getSource());
        req.setTarget(tencentApiProperties.getTarget());
        req.setSourceText(text);
        req.setProjectId(1);
        // 通过client对象调用想要访问的接口，需要传入请求对象
        TextTranslateResponse resp = client.TextTranslate(req);
        return resp.getTargetText();
    }

    @Override
    public String fromImage(String data) throws TencentCloudSDKException {
        TmtClient client = getClient();
        ImageTranslateRequest req = new ImageTranslateRequest();
        req.setSource(tencentApiProperties.getSource());
        req.setTarget(tencentApiProperties.getTarget());
        req.setScene(tencentApiProperties.getScene());
        req.setSessionUuid(UUID.randomUUID().toString());
        req.setData(data);
        req.setProjectId(1);
        // 通过client对象调用想要访问的接口，需要传入请求对象
        ImageTranslateResponse resp = client.ImageTranslate(req);
        return resp.getTarget();
    }
}
