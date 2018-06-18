package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.dto.BroadcastMessageDto;
import cn.caijinbiao.assistant.to.BroadcastMessageTo;
import cn.caijinbiao.assistant.properties.WeChatApiProperties;
import cn.caijinbiao.assistant.service.AccessTokenService;
import cn.caijinbiao.assistant.service.PreviewService;
import cn.caijinbiao.assistant.dto.AccessTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PreviewServiceImpl implements PreviewService {

    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WeChatApiProperties weChatApiProperties;
    @Autowired
    BroadcastMessageTo broadcastMessageTo;

    @Override
    public BroadcastMessageDto preview(String text) {
        AccessTokenDto accessTokenDto = accessTokenService.getAccessTokenDto();
        String token = accessTokenDto.getAccess_token();
        return fetchWeChat(text, token);
    }

    private void setFilter() {
        Map<String, Object> filter = new HashMap<>();
        filter.put("is_to_all", false);
        filter.put("tag_id", 2);
        broadcastMessageTo.setFilter(filter);
    }

    private void setContent(String content) {
        Map<String, String> text = new HashMap<>();
        text.put("content", content);
        broadcastMessageTo.setText(text);
    }

    private BroadcastMessageDto fetchWeChat(String text, String token) {
        String url = "https://" + weChatApiProperties.DOMAIN + "/cgi-bin/message/mass/preview?access_token=" + token;
        setFilter();
        setContent(text);
        ResponseEntity<BroadcastMessageDto> responseEntity = restTemplate.postForEntity(url, broadcastMessageTo, BroadcastMessageDto.class);
        return responseEntity.getBody();
    }
}
