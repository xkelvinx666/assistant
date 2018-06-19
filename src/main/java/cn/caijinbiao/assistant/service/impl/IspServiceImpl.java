package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.mapper.IspMapper;
import cn.caijinbiao.assistant.model.Isp;
import cn.caijinbiao.assistant.model.IspExample;
import cn.caijinbiao.assistant.service.IspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IspServiceImpl implements IspService {
    @Autowired
    IspMapper ispMapper;
    @Override
    public void addIsp(String name) {
        Isp isp = new Isp();
        isp.setName(name);
        ispMapper.insert(isp);
    }

    @Override
    public Isp getIsp(String name) {
        IspExample typeExample = new IspExample();
        IspExample.Criteria criteria = typeExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Isp> isps = ispMapper.selectByExample(typeExample);
        if(null == isps || 0 == isps.size()) {
            addIsp(name);
            isps = ispMapper.selectByExample(typeExample);
        }
        return isps.get(0);
    }
}
