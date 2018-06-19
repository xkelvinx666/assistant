package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.model.User;

public interface UserService {
    int addUser(String openId);
    User getUser(String openId);
}
