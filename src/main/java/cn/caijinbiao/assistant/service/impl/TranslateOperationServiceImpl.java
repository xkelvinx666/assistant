package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.properties.TencentApiProperties;
import cn.caijinbiao.assistant.service.TranslateOperationService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TranslateOperationServiceImpl implements TranslateOperationService {
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
        req.setSource("en");
        req.setTarget("zh");
        req.setScene(tencentApiProperties.getScene());
        req.setSessionUuid(UUID.randomUUID().toString());
        req.setData(data);
        req.setProjectId(1);
        // 通过client对象调用想要访问的接口，需要传入请求对象
        ImageTranslateResponse resp = client.ImageTranslate(req);
        ItemValue[] itemValues = resp.getImageRecord().getValue();
        StringBuilder source = new StringBuilder("源文字: ");
        StringBuilder target = new StringBuilder("\n翻译文字: ");
        for(ItemValue itemValue : itemValues) {
            source.append(itemValue.getSourceText() + "\n");
            target.append(itemValue.getTargetText()+ "\n");
        }
        return source.toString() + target.toString();
    }
}
