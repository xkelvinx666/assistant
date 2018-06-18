package cn.caijinbiao.assistant.controller;

import cn.caijinbiao.assistant.dto.BroadcastMessageDto;
import cn.caijinbiao.assistant.dto.message.user.FromMessageDto;
import cn.caijinbiao.assistant.dto.message.user.ToMessageDto;
import cn.caijinbiao.assistant.response.ResponseResult;
import cn.caijinbiao.assistant.service.*;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
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
    UserMessageService userMessageService;
    @Autowired
    TranslateService translateService;
    @Autowired
    FromMessageDto fromMessageDto;

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

    @PostMapping(produces = "application/xml;charset=UTF-8")
    public ToMessageDto handleWeChatMessage(@RequestBody FromMessageDto fromMessageDto) throws TencentCloudSDKException {
        String content = translateService.fromText(fromMessageDto.getContent());
        return userMessageService.sendContent(fromMessageDto, content);
    }

    @PostMapping(value = "preview")
    public ResponseResult<BroadcastMessageDto> preview(String text) {
        return new ResponseResult<>(previewService.preview(text));
    }

}
