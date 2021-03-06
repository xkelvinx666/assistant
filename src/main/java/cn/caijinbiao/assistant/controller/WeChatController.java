package cn.caijinbiao.assistant.controller;

import cn.caijinbiao.assistant.dto.BroadcastMessageDto;
import cn.caijinbiao.assistant.dto.message.user.FromMessageDto;
import cn.caijinbiao.assistant.entity.Isp;
import cn.caijinbiao.assistant.entity.Translate;
import cn.caijinbiao.assistant.entity.Type;
import cn.caijinbiao.assistant.entity.User;
import cn.caijinbiao.assistant.response.ResponseResult;
import cn.caijinbiao.assistant.service.*;
import cn.caijinbiao.assistant.util.CommonUtil;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
    FromMessageDto fromMessageDto;
    @Autowired
    TypeService typeService;
    @Autowired
    UserService userService;
    @Autowired
    IspService ispService;
    @Autowired
    TranslateService translateService;
    @Autowired
    HabitService habitService;
    @Autowired
    TranslateOperationService translateOperationService;

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
    public Object handleWeChatMessage(@RequestBody FromMessageDto fromMessageDto) throws TencentCloudSDKException, IOException {
        CommonUtil.isNotNullOrEmpty(fromMessageDto.getFromUserName(), "用户openid为空");
        CommonUtil.isNotNullOrEmpty(fromMessageDto.getToUserName(), "目的openid为空");
        CommonUtil.isNotNullOrEmpty(fromMessageDto.getMsgType(), "消息类型为空");
        String msgType = fromMessageDto.getMsgType();

        Type type = typeService.promiseGetByName(msgType);
        User user = userService.promiseGetByName(fromMessageDto.getFromUserName());
        Isp isp = ispService.promiseGetByName("腾讯云api");
        String data = fromMessageDto.getContent();
        if(null == data) {
            data = fromMessageDto.getPicUrl();
        }
        Translate translate = translateService.promiseGetTranslate(data, type, isp);
        habitService.updateHabit(translate.getId(), user.getId());
        return userMessageService.sendContent(fromMessageDto, translate.getTarget());
    }

    @PostMapping(value = "preview")
    public ResponseResult<BroadcastMessageDto> preview(String text) {
        return new ResponseResult<>(previewService.preview(text));
    }

}
