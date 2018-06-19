package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.mapper.TranslateMapper;
import cn.caijinbiao.assistant.model.Translate;
import cn.caijinbiao.assistant.model.TranslateExample;
import cn.caijinbiao.assistant.service.TranslateOperationService;
import cn.caijinbiao.assistant.service.TranslateService;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslateServiceImpl implements TranslateService {
    @Autowired
    TranslateMapper translateMapper;
    @Autowired
    TranslateOperationService translateOperationService;

    @Override
    public void addTranslate(String source, String target, long type, long isp) {
        Translate translate = new Translate();
        translate.setSource(source);
        translate.setTarget(target);
        translate.setType(type);
        translate.setIsp(isp);
        translateMapper.insert(translate);
    }

    @Override
    public Translate getTranslate(String source, long type, long isp) throws TencentCloudSDKException {
        TranslateExample translateExample = new TranslateExample();
        TranslateExample.Criteria criteria = translateExample.createCriteria();
        criteria.andSourceEqualTo(source);
        criteria.andTypeEqualTo(type);
        criteria.andIspEqualTo(isp);
        List<Translate> translates = translateMapper.selectByExample(translateExample);
        if (null == translates || 0 == translates.size()) {
            String target = translateOperationService.fromText(source);
            addTranslate(source, target, type, isp);
            translates = translateMapper.selectByExample(translateExample);
        }
        return translates.get(0);
    }
}
