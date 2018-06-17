package cn.caijinbiao.assistant.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("classpath:config/sign-token.properties")
public class SignTokenProperties {
    @Value("${token}")
    private String token;
}
