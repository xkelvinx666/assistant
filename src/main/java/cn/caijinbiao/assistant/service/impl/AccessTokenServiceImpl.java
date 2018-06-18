package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.exception.CheckException;
import cn.caijinbiao.assistant.properties.AccessTokenProperties;
import cn.caijinbiao.assistant.properties.WeChatApiProperties;
import cn.caijinbiao.assistant.service.AccessTokenService;
import cn.caijinbiao.assistant.dto.AccessTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    private AccessTokenDto accessTokenDto;
    @Autowired
    private AccessTokenProperties accessTokenProperties;
    @Autowired
    private WeChatApiProperties weChatApiProperties;
    @Autowired
    private RestTemplate restTemplate;

    public AccessTokenDto getAccessTokenDto() {
        if (null == accessTokenDto || accessTokenDto.isExpires()) {
            updateAccessToken();
        }
        return accessTokenDto;
    }

    private AccessTokenDto fetchAcessToken() {
        String url = "https://" + weChatApiProperties.DOMAIN + "/cgi-bin/token?grant_type=" + accessTokenProperties.GRANT_TYPE + "&appid=" + accessTokenProperties.getAppId() + "&secret=" + accessTokenProperties.getSecret();
        ResponseEntity<AccessTokenDto> responseEntity = restTemplate.getForEntity(url, AccessTokenDto.class);
        if(HttpStatus.OK == responseEntity.getStatusCode()  && responseEntity.getBody().isOK()) {
            return responseEntity.getBody();
        } else if(HttpStatus.OK != responseEntity.getStatusCode()){
            // HTTP状态码不是200时打印完整信息
            throw new CheckException("获取access_token失败" + responseEntity.toString());
        } else {
            AccessTokenDto accessTokenDto = responseEntity.getBody();
            throw new CheckException("获取access_token失败" + " errcode :" + accessTokenDto.getErrcode() + " errmsg :" + accessTokenDto.getErrmsg());
        }
    }

    private void updateAccessToken() {
        AccessTokenDto accessTokenDto = fetchAcessToken();
        this.accessTokenDto.setAccess_token(accessTokenDto.getAccess_token());
        this.accessTokenDto.setExpires_in(accessTokenDto.getExpires_in());
    }
}
