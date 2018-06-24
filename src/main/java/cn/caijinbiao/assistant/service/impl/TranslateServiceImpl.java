package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.entity.Translate;
import cn.caijinbiao.assistant.mapper.TranslateMapper;
import cn.caijinbiao.assistant.service.TranslateService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jinbiaocai
 * @since 2018-06-24
 */
@Service
public class TranslateServiceImpl extends BaseServiceImpl<TranslateMapper, Translate> implements TranslateService {

    @Autowired
    TranslateOperationServiceImpl translateOperationService;

    public boolean addTranslate(String source, long type, long isp) throws TencentCloudSDKException {
        Translate translate = new Translate();
        translate.setSource(source);
        translate.setType(type);
        translate.setIsp(isp);
        String target = translateOperationService.fromText(source);
        translate.setTarget(target);
        return insert(translate);
    }

    @Override
    public Translate promiseGetTranslate(String source, long type, long isp) throws TencentCloudSDKException {
        Translate translate = selectOne(new EntityWrapper<Translate>()
                .eq("f_source", source)
                .eq("f_type", type)
                .eq("f_isp", isp));
        addTranslate(source, type, isp);
        return translate;
    }
}
