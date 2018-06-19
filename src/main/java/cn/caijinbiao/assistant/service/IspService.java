package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.model.Isp;

public interface IspService {
    void addIsp(String name);
    Isp getIsp(String name);
}
