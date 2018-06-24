package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.entity.BaseEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface BaseService<T extends BaseEntity> extends IService<T> {
    boolean deleteByName(String name);
    List<T> listByName(String name);
    T getByName(String name);
    T promiseGetByName(String name);
}
