package cn.caijinbiao.assistant.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:config/access-token.properties")
public class AccessTokenProperties {
    public static final String GRANT_TYPE = "client_credential";
    @Value("${appid}")
    private String appId;
    @Value("${secret}")
    private String secret;
}
