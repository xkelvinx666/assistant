package cn.caijinbiao.assistant;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.tmt.v20180321.TmtClient;
import com.tencentcloudapi.tmt.v20180321.models.ImageTranslateRequest;
import com.tencentcloudapi.tmt.v20180321.models.ImageTranslateResponse;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateRequest;
import com.tencentcloudapi.tmt.v20180321.models.TextTranslateResponse;
import org.junit.Test;

import java.util.UUID;

public class TencentCloudTests {
    Credential cred = new Credential("AKIDvkS0Sku0PdgYYRw4d3PbiT9fOZdZr2b0", "RhmdMvaeAh9VikbKk3QkuQmEIBwY1KTh");
    TmtClient client = new TmtClient(cred, "ap-guangzhou");
    @Test
    public void testTranslateText() {
        // 实例化一个请求对象
        TextTranslateRequest req = new TextTranslateRequest();
        req.setSource("auto");
        req.setTarget("zh");
        req.setSourceText("test");
        req.setProjectId(1);

        // 通过client对象调用想要访问的接口，需要传入请求对象
        TextTranslateResponse resp = null;
        try {
            resp = client.TextTranslate(req);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        // 输出json格式的字符串回包
        System.out.println(resp.getTargetText());
    }

    @Test
    public void testTranslateImage() {
        // 实例化一个请求对象
        ImageTranslateRequest req = new ImageTranslateRequest();
        req.setSource("en");
        req.setTarget("zh");
        req.setSessionUuid(String.valueOf(UUID.randomUUID()));
        req.setScene("doc");
        req.setData("data:image/png;base64,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");
        req.setProjectId(1);

        // 通过client对象调用想要访问的接口，需要传入请求对象
        ImageTranslateResponse resp = null;
        try {
            resp = client.ImageTranslate(req);
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        // 输出json格式的字符串回包
        System.out.println(resp.getTarget());
    }
}