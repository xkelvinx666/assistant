package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.model.Type;

public interface TypeService {
    void addType(String name);
    Type getType(String name);
}
