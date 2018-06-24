package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.entity.Isp;
import cn.caijinbiao.assistant.entity.Translate;
import cn.caijinbiao.assistant.entity.Type;
import cn.caijinbiao.assistant.service.BaseService;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import java.io.IOException;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jinbiaocai
 * @since 2018-06-24
 */
public interface TranslateService extends BaseService<Translate> {
    Translate promiseGetTranslate(String source, Type type, Isp isp) throws TencentCloudSDKException, IOException;
}
