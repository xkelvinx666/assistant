package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.dto.message.user.FromMessageDto;
import cn.caijinbiao.assistant.dto.message.user.ToMessageDto;

public interface UserMessageService {
    ToMessageDto sendContent(FromMessageDto fromMessageDto, String content);
}
