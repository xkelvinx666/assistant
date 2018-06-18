package cn.caijinbiao.assistant.controller;

import cn.caijinbiao.assistant.dto.BroadcastMessageDto;
import cn.caijinbiao.assistant.dto.PersonalMessageDto;
import cn.caijinbiao.assistant.response.ResponseResult;
import cn.caijinbiao.assistant.service.AccessTokenService;
import cn.caijinbiao.assistant.service.PreviewService;
import cn.caijinbiao.assistant.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("wechat")
public class WeChatController {
    @Autowired
    SignService signService;
    @Autowired
    AccessTokenService accessTokenService;
    @Autowired
    PreviewService previewService;
    @Autowired
    PersonalMessageDto personalMessageDto;

    //验证是否来自微信服务器的消息
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String checkSignature(String signature, String timestamp, String echostr, String nonce) {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signService.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        } else {
            signService.isIllegalSignature();
            return "非法请求";
        }
    }

    @PostMapping(produces = "application/xml; charset=UTF-8")
    public PersonalMessageDto handleWeChatMessage(PersonalMessageDto personalMessageDto) {
        return personalMessageDto;
    }

    @PostMapping(value = "preview")
    public ResponseResult<BroadcastMessageDto> preview(String text) {
        return new ResponseResult<>(previewService.preview(text));
    }

}
