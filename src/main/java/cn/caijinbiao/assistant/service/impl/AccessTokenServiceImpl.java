package cn.caijinbiao.assistant.service.impl;

import cn.caijinbiao.assistant.exception.CheckException;
import cn.caijinbiao.assistant.properties.AccessTokenProperties;
import cn.caijinbiao.assistant.properties.WeChatApiProperties;
import cn.caijinbiao.assistant.service.AccessTokenService;
import cn.caijinbiao.assistant.to.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    private AccessToken accessToken;
    @Autowired
    private AccessTokenProperties accessTokenProperties;
    @Autowired
    private WeChatApiProperties weChatApiProperties;
    @Autowired
    private RestTemplate restTemplate;

    public AccessToken getAccessToken() {
        if (null == accessToken || accessToken.isExpires()) {
            updateAccessToken();
        }
        return accessToken;
    }

    private AccessToken fetchAcessToken() {
        String url = "https://" + weChatApiProperties.DOMAIN + "/cgi-bin/token?grant_type=" + accessTokenProperties.GRANT_TYPE + "&appid=" + accessTokenProperties.getAppId() + "&secret=" + accessTokenProperties.getSecret();
        ResponseEntity<AccessToken> responseEntity = restTemplate.getForEntity(url, AccessToken.class);
        if(HttpStatus.OK == responseEntity.getStatusCode()  && responseEntity.getBody().isOK()) {
            return responseEntity.getBody();
        } else if(HttpStatus.OK != responseEntity.getStatusCode()){
            // HTTP状态码不是200时打印完整信息
            throw new CheckException("获取access_token失败" + responseEntity.toString());
        } else {
            AccessToken accessToken = responseEntity.getBody();
            throw new CheckException("获取access_token失败" + " errcode :" + accessToken.getErrcode() + " errmsg :" + accessToken.getErrmsg());
        }
    }

    private void updateAccessToken() {
        AccessToken accessToken = fetchAcessToken();
        this.accessToken.setAccess_token(accessToken.getAccess_token());
        this.accessToken.setExpires_in(accessToken.getExpires_in());
    }
}
