package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.mapper.UserMapper;
import cn.caijinbiao.assistant.model.User;
import cn.caijinbiao.assistant.model.UserExample;
import cn.caijinbiao.assistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(String openId) {
        User user = new User();
        user.setOpenId(openId);
        return userMapper.insert(user);
    }

    @Override
    public User getUser(String openId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andOpenIdEqualTo(openId);
        List<User> users = userMapper.selectByExample(userExample);
        if (null == users || 0 == users.size()) {
            addUser(openId);
            users = userMapper.selectByExample(userExample);
        }
        return users.get(0);
    }
}
