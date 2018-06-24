package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.entity.BaseEntity;
import cn.caijinbiao.assistant.service.BaseService;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

public class BaseServiceImpl<C extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<C, T> implements BaseService<T> {
    @Override
    public boolean deleteByName(String name) {
        return delete(new EntityWrapper<T>().eq("f_name", name));
    }

    @Override
    public List<T> listByName(String name) {
        return selectList(new EntityWrapper<T>().eq("f_name", name));
    }

    @Override
    public T getByName(String name) {
        return selectOne(new EntityWrapper<T>().eq("f_name", name));
    }

    @Override
    public T promiseGetByName(String name) {
        T t = getByName(name);
        if(null == t) {
            t = (T) new BaseEntity<T>();
            t.setName(name);
            insert(t);
        }
        return t;
    }

}
