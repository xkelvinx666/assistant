package cn.caijinbiao.assistant.service;

import cn.caijinbiao.assistant.dto.BroadcastMessageDto;

public interface PreviewService {
    BroadcastMessageDto preview(String text);
}
