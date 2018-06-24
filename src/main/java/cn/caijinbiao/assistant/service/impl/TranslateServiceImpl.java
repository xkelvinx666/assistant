package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.entity.Isp;
import cn.caijinbiao.assistant.entity.Translate;
import cn.caijinbiao.assistant.entity.Type;
import cn.caijinbiao.assistant.mapper.TranslateMapper;
import cn.caijinbiao.assistant.service.TranslateService;
import cn.caijinbiao.assistant.util.ImageUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

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

    public boolean addTranslate(String source, Type type, Isp isp) throws TencentCloudSDKException, IOException {
        Translate translate = new Translate();
        translate.setSource(source);
        translate.setType(type.getId());
        translate.setIsp(isp.getId());
        if("image".equals(type.getName())) {
            byte[] images = ImageUtil.fetchImageByUrl(source);
            String imageBase64 = ImageUtil.ImageToBase64(images);
            translate.setTarget(translateOperationService.fromImage(imageBase64));
        } else {
            translate.setTarget(translateOperationService.fromText(source));
        }
        return insert(translate);
    }

    @Override
    public Translate promiseGetTranslate(String source, Type type, Isp isp) throws TencentCloudSDKException, IOException {
        Wrapper<Translate> select = new EntityWrapper<Translate>()
                .eq("f_source", source)
                .eq("f_type", type.getId())
                .eq("f_isp", isp.getId());
        Translate translate = selectOne(select);
        if(null == translate && addTranslate(source, type, isp)) {
            translate = selectOne(select);
        }
        return translate;
    }
}
