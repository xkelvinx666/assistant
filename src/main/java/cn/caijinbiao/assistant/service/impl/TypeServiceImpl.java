package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.mapper.TypeMapper;
import cn.caijinbiao.assistant.model.Type;
import cn.caijinbiao.assistant.model.TypeExample;
import cn.caijinbiao.assistant.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public void addType(String name) {
        Type type = new Type();
        type.setName(name);
        typeMapper.insert(type);
    }

    @Override
    public Type getType(String name) {
        TypeExample typeExample = new TypeExample();
        TypeExample.Criteria criteria = typeExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Type> types = typeMapper.selectByExample(typeExample);
        if(null == types || 0 == types.size()) {
            addType(name);
            types = typeMapper.selectByExample(typeExample);
        }
        return types.get(0);
    }
}
