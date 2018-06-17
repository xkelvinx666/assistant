package cn.caijinbiao.assistant.controller;

import cn.caijinbiao.assistant.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/wechat")
public class WeChatController {
    @Autowired
    SignService signService;

    //验证是否来自微信服务器的消息
    @GetMapping(value = "security")
    public void checkSignature(HttpServletResponse response, String signature,String timestamp,  String echostr, String nonce) throws IOException {
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (signService.checkSignature(signature, timestamp, nonce)) {
            response.getWriter().print(echostr);
        } else {
            signService.isIllegalSignature();
        }
    }
}
