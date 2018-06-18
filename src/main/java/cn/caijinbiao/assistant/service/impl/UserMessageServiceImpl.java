package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.dto.message.user.FromMessageDto;
import cn.caijinbiao.assistant.dto.message.user.ToMessageDto;
import cn.caijinbiao.assistant.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageServiceImpl implements UserMessageService {
    @Autowired
    ToMessageDto toMessageDto;

    private void beforeSend(FromMessageDto fromMessageDto) {
        toMessageDto.setFromUserName(fromMessageDto.getToUserName());
        toMessageDto.setToUserName(fromMessageDto.getFromUserName());
    }
    private void afterSend() {
        long currentTime = System.currentTimeMillis() / 1000;
        toMessageDto.setCreateTime(currentTime);
    }

    @Override
    public ToMessageDto sendContent(FromMessageDto fromMessageDto, String content) {
        beforeSend(fromMessageDto);
        toMessageDto.setContent(content);
        toMessageDto.setMsgType("text");
        afterSend();
        return toMessageDto;
    }
}
